# Passwordless Authentication App (Email + OTP)

This Android project implements a passwordless login system using Email and OTP authentication.  
After successful login, the user enters a session screen showing session time and duration.

The project is built as part of an Android assignment to demonstrate Jetpack Compose, ViewModel architecture, coroutines, and proper state handling.

---

## Tech Stack Used
- Kotlin
- Jetpack Compose UI
- ViewModel + UI State architecture
- Kotlin Coroutines
- Timber (External SDK for logging)
- Android Studio

---

## Features Implemented
- Email + OTP based login
- OTP stored per email
- Maximum 3 OTP attempts allowed
- Resend OTP invalidates previous OTP
- Attempt count resets on new OTP
- OTP expiry handling
- Session screen after login
- Shows session start time
- Live session timer (mm:ss)
- Logout button
- Timer survives recomposition
- Timer stops on logout
- Screen rotation does not break state
- Logging events using Timber

---

## OTP Logic and Expiry Handling
OTP generation happens through `OtpManager`.

Flow:
1. User enters email.
2. OTP is generated and stored in a Map using email as key.
3. OTP is valid only for a fixed duration.
4. User has only **3 attempts** to enter correct OTP.
5. If OTP expires or attempts exceed limit, user must request a new OTP.
6. Generating new OTP:
   - Invalidates old OTP
   - Resets attempt count

This prevents reuse and brute-force attempts.

---

## Data Structures Used
Mainly used:
- `Map<String, OtpData>`

Reason:
Each email must store its own OTP data.  
Map makes lookup easy and fast using email as key.

OtpData stores:
- OTP value
- Expiry time
- Attempt count

This keeps OTP logic simple and scalable.

---

## External SDK Used
I integrated **Timber** for logging.

Reason:
- Lightweight
- Easy logging
- Useful for debugging and tracking events

Logged events:
- OTP generated
- OTP validation success
- OTP validation failure
- Logout event

---

## Architecture Overview
Project follows clean separation:

- UI handles Compose screens only
- ViewModel handles business logic
- OtpManager handles OTP operations
- Analytics logger handles logging

One-way data flow is maintained between ViewModel and UI.

---

## Compose Concepts Used
- @Composable functions
- remember & rememberSaveable
- LaunchedEffect
- State hoisting
- Recomposition handling
- ViewModel state observation

---

## Edge Cases Handled
- OTP expiry
- Wrong OTP entry
- Max attempts exceeded
- Resend OTP flow
- Rotation safe state
- Logout clears session

---

## What I Used GPT For vs What I Implemented
Used GPT mainly for:
- Understanding Compose state handling
- Structuring ViewModel logic
- Debugging coroutine issues
- Suggestions for project structure

Implemented by myself:
- OTP logic
- Attempt tracking
- UI screens
- Session timer
- ViewModel state management
- Logging integration
- Flow handling

All code was manually written and understood.

---

## Setup Instructions
1. Clone repository
2. Open project in Android Studio
3. Sync Gradle
4. Run app on emulator/device

No extra configuration required.

---

## Bonus Implemented
✔ Retry cooldown logic  
✔ Sealed UI states for cleaner state handling

---

## Conclusion
This project helped me understand:
- Compose recomposition
- ViewModel usage
- State management
- Coroutine usage
- OTP authentication flow

Overall, it was a good exercise in real-world Android app architecture.

---
