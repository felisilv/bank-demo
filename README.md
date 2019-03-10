# Rich vs Anemic Domain Model

This repository is created to promote discussion on different strategies for model creation.

Recommended reading:
- https://www.martinfowler.com/bliki/AnemicDomainModel.html
- https://www.javaworld.com/article/2073723/why-getter-and-setter-methods-are-evil.html
- https://martinfowler.com/ieeeSoftware/protectedVariation.pdf
- https://blog.codecentric.de/en/2016/02/write-accessor-methods/

Recommended trainings:
- https://app.pluralsight.com/library/courses/java-fundamentals-object-oriented-design
- https://app.pluralsight.com/library/courses/encapsulation-solid
- https://app.pluralsight.com/library/courses/refactoring-anemic-domain-model
- https://learning.oreilly.com/live-training/courses/domain-driven-design-and-event-driven-microservices

To help with the analysis, one bank application was created using anemic models.
** anemic models are simple objects created with private fields and getters and setters methods. It is commonly referred as Pojos.

The goal for this project is to show pros and cons while refactoring the bank application by adding rich models.


Planned development iterations:
### Iteration  1:
- Bank application created with functionalities:
  - ability to create customer
  - ability to create savings and current account

### Iteration  2:
- Implement customer Id verification for account creation
  - new account should not be created with invalid user Id
  - each user can only have one account per type
    - attempt to create account for a user that already have one should return error
    
### Iteration  3: 
- As every bank we should have several agencies
  - each agency have one principalManager
  - each account is assigned to one agency
  - customers now can have accounts in several agencies (despite of account type)