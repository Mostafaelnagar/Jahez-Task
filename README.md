<h1 align="center">
Jahez Chat Task
</h1>

:point_right: Architecture:
-----------------
- Following Clean Architecture.
- MVVM Architecture.
- Repository pattern.
- Use Cases.
- Applying SOLID principles, each class has a single job with separation of concerns by making classes independent
  of each other and communicating with interfaces.
- Using Kotlin-KTS & buildSrc to handle project dependencies.


:point_right: Tech Stack & Libraries:
-----------------
- Navigation component - navigation graph for navigating between screens
- ViewModel - UI-related data holder, lifecycle aware.
- Flow & StateFlow - Build data objects that notify views when the data changes.
- Dagger-Hilt for dependency injection. Object creation and scoping are handled by Hilt.
- Kotlin Coroutines - for managing background threads with simplified code and reducing the need for callbacks
- Retrofit2 & OkHttp3 - to integrate REST requests to the web service.
- Coil - for image loading.
- Compose - for building the UI
- Room DB - for the caching mechanism
  
:point_right: Project Structure:
-----------------
- Sample includes some basic Modules required in each project like :
  - App Module => (Controll everything in the app ).
  - Core Module = > (contain shared components between modules like theme).
  - Network Module - (Contain the base network calls and get the result from the server).
  - Storage Module - (This module is for shared caching business like caching user info ).
  - Navigation Module -(This Module controls the navigation between different screens that are located in different modules).

:point_right: Feature Module:
-----------------
- Chat Modlue -> This is the feature we have here in this sample building using Compose

:point_right: Apply Git Hooks:
-----------
- To apply git hooks to automate the process of styling and checking your code, just follow these steps:
  - Copy ```pre-commit``` file depending on your OS from ```myGitHooks```.
  - Paste it into ```.git/hooks``` in your project.
- Now each time you commit your changes, ```ktlintFormat``` and  ```ktlintCheck``` will automatically run

