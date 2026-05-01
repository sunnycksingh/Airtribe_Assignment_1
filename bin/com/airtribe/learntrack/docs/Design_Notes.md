1. Why you used ArrayList instead of array ?

**Answer:**  

We used ArrayList because it can grow dynamically, unlike array which has fixed size.

- Array has fixed size → cannot change after creation  
- Project data is not fixed → students/courses can increase  
- ArrayList grows automatically  
- Provides easy methods like add(), remove(), get().


2. Where you used static members and why ?

**Answer:**  

We used static for shared/common data and when no object creation is required.

- Used in main method → program starts from here  
- Used for common values like ID counters  
- static belongs to class, not object  
- One value is shared across all objects 


3. Where you used inheritance and what you gained from it ?

**Answer:**  
We used inheritance to reuse common properties and avoid duplication, making the code clean and manageable.

- One class uses properties of another class  
- Example: User (parent), Student (child)  
- Avoid rewriting same fields like name, email  

### Benefits:
- Code reuse  
- Cleaner structure  
- Easy maintenance  
- Real-world relationship representation  