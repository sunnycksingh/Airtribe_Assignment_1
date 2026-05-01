# LearnTrack Student Management Assignment

## Project description

This Java project is a simple console-based student, course, and enrollment management application.
It is organized using packages under `src/com/airtribe/learntrack` and demonstrates basic object-oriented design, custom exceptions, and service/repository separation.

Key responsibilities:
- `com.airtribe.learntrack.Main` - main program entry point for the menu-driven application.
- `com.airtribe.learntrack.entity` - data model classes: `Student`, `Course`, `Enrollment`, and `Person`.
- `com.airtribe.learntrack.service` - business logic for managing students, courses, and enrollments.
- `com.airtribe.learntrack.repository` - data storage and retrieval implementations for entities.
- `com.airtribe.learntrack.exception` - custom exception handling (for missing entities, etc.).
- `com.airtribe.learntrack.util` - helper utilities such as `IdGenerator`.
- `com.airtribe.learntrack.enums` - enums used by the application, such as enrollment status.
- `com.airtribe.learntrack.constants` - application constants.
- `com.airtribe.learntrack.docs` - project documentation and diagrams.

The app allows users to:
- add and view students
- search for students by ID
- deactivate students
- add and view courses
- activate/deactivate courses
- manage enrollments between students and courses

> Note: `src/App.java` is a separate sample class that prints `Hello, World!`. The main learning application starts from `src/com/airtribe/learntrack/Main.java`.

## How to compile and run

### Using Windows Command Prompt

Open a command prompt in the project root folder (`d:\Sunny\Java_Airtribe\Assignment_1`) and run:

```bat
javac -d bin src\com\airtribe\learntrack\Main.java src\com\airtribe\learntrack\entity\*.java src\com\airtribe\learntrack\service\*.java src\com\airtribe\learntrack\repository\*.java src\com\airtribe\learntrack\exception\*.java src\com\airtribe\learntrack\util\*.java src\com\airtribe\learntrack\enums\*.java
```

Then run the application with:

```bat
java -cp bin com.airtribe.learntrack.Main
```

### Using PowerShell

From the project root:

```powershell
javac -d bin src\com\airtribe\learntrack\Main.java src\com\airtribe\learntrack\entity\*.java src\com\airtribe\learntrack\service\*.java src\com\airtribe\learntrack\repository\*.java src\com\airtribe\learntrack\exception\*.java src\com\airtribe\learntrack\util\*.java src\com\airtribe\learntrack\enums\*.java
java -cp bin com.airtribe.learntrack.Main
```

### If you want to compile all `.java` files recursively

In PowerShell, you can also use:

```powershell
Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { javac -d bin $_.FullName }
```

## Notes

- Make sure Java is installed and `javac`/`java` are available on your PATH.
- `bin` is the output folder for compiled `.class` files.
- The main application menu is controlled from `src/com/airtribe/learntrack/Main.java`.


- Class diagram

-  `src/com/airtribe/learntrack/docs/Class_Diagram.png`


