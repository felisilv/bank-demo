# Rich vs Anemic Domain Model

This repository is created to promote the discussion about different strategies on model creation.

The motivation can be found on:
- https://www.martinfowler.com/bliki/AnemicDomainModel.html
- https://www.javaworld.com/article/2073723/why-getter-and-setter-methods-are-evil.html
- https://martinfowler.com/ieeeSoftware/protectedVariation.pdf
- https://blog.codecentric.de/en/2016/02/write-accessor-methods/

To help with the analysis, one bank application was created using anemic models.

** anemic models are simple objects created with private fields with getters and setters commonly referred as Pojos.

The goal for this project is to show pros and cons while refactoring the bank application by adding rich models.

Maybe we can add Domain Driven Design to this discussion and Eric Evans recommendations. 


### Phase 1:
- Bank application created with
  - create customer
  - create savings and current account

### Phase 2:
- Implement customer Id verification for account creation
  - new account should not be created with invalid user Id
  - each user can only have one account per type
    - attempt to create account for a user that already have one should return error
    
### Phase 3: 
- As every bank we should have several agencies
  - each agency have one principalManager
  - each account is assigned to one agency
  - customers now can have accounts in several agencies (despite of account type)