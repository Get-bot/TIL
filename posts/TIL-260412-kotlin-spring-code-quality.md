---
title: "[TIL-260412] PR 리뷰로 정리�� Kotlin/Spring Boot 코드 품질 패턴"
date: 2026-04-12
tags: ["Kotlin", "Spring Boot", "enum lazy", "Bean Validation", "코드 리뷰"]
categories: ["TIL"]
description: "Kotlin enum 전방 참조 + by lazy 캐싱, kotlin-stdlib 자동 추가, Bean Validation nullable 패턴"
---

## 잘한 점

### 3-에이전트 병렬 코드 리뷰로 체계적 품질 점���

**상황**
- event-crud API 구현이 끝나고 PR을 올리기 전 단계
- 코드가 동작은 하는데, 품질 관점에서 놓친 게 없는지 점검이 필요했음
- `/simplify` 스킬로 재사용/품질/효율성 3개 관점의 리뷰 에이전트를 병렬 실행

**액션**
- 3��� 에이��트가 각각 다른 관점으로 동시에 리뷰 → 6개 실질적 이슈 도출
- 각 이슈를 하나씩 "왜 문제인지" 확인한 뒤 직접 수정
- 에이전트 제안을 그대로 ���르지 않고, EventStatus는 `when` + `by lazy`로 더 ���끔하게 변경하고, 미사용 `isIssuable()` 메서드도 같이 정리

**칭���**
- AI 리뷰 결과를 맹목적으로 수용하지 않고, 각 항목을 직접 판단해서 취사선택��� 점
- 제안된 것 외에 Kotest 6.1.0 / MockK 1.14.9 업그���이드 + 버전 변수 추출까지 추가로 챙긴 점

---

## 개선점

오늘은 특별히 없음

---

## 배운 점

### Kotlin enum 전방 참조와 lazy 초기화

**배움**
- `EventStatus`에서 `READY`�� `setOf(OPEN)`을 참조하���데, enum은 선언 순서대로 초기화되니까 `READY` 시점에 `OPEN`이 ���직 없음
- 그래서 ��다 `() -> Set<EventStatus>`로 지연 평가하고 있었는데, ���러면 `canTransitionTo()` 호출마다 ��� Set이 힙��� 생성됨
- `by lazy`로 감싸면 첫 호출 시 한 번만 평가하고 이후 캐싱 → 고빈도 호출에서 GC 압력 감소

**의미**
- enum에서 다른 enum 값을 참조할 때는 전방 참조 ��약을 항상 의식해야 한다
- `by lazy`는 ��런 상황에서 깔끔한 해결��� — 단순히 "지연 로딩"용이 아니라 "초기화 순서 제약 우회 + 캐싱"으로도 유용

---

## 핵심 내용

### 키워드
- `Kotlin enum lazy`, `by lazy`, `kotlin-stdlib 자동 추가`, `Bean Validation @field:NotNull vs non-null 타입`

### 요약
- Kotlin Gradle 플러그인은 `kotlin-stdlib`를 자동 추가한다. 명��적 `implementation(kotlin("stdlib"))`는 중���이므로 제거.
- Kotlin enum에서 다른 enum 값을 참조할 때 전방 참조 제약이 ��다. 람��로 지연 평가하되 `by lazy`로 캐싱하면 매 호출 객체 생성을 방지할 수 있다.
- DTO에서 `Int?` + `@field:NotNull` + `!!` 패턴��� 의도적이다. non-null 타입으로 선언하면 JSON null 시 Jackson 역직렬화에서 먼저 터져서 Bean Validation의 사용자 친화적 에러 메시지가 나오지 않는다. `@field:NotBlank`는 null 체크를 포함하므로 `String`(non-null) 사용 가��.
- 같은 패키지 내 클래스는 import 없이 참��� 가능. IDE 자동 import가 불필요한 import를 추가하는 경우가 있다.

### 코드/명령어

```kotlin
// Before: 매 호출마다 ��� Set 생성
enum class EventStatus(
    private val allowedTransitions: () -> Set<EventStatus>,
) {
    READY({ setOf(OPEN) }),  // ��출할 때마다 setOf() 실행
}

// After: lazy로 1회만 ��성, 이후 캐싱
enum class EventStatus {
    READY;
    val allowedTransitions: Set<EventStatus> by lazy {
        when (this) {
            READY -> setOf(OPEN)
            OPEN -> setOf(CLOSED)
            CLOSED -> emptySet()
        }
    }
}
```
