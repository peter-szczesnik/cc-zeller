# cc-zeller

Proof of concept skeleton banking application using the following components:
  - mvvm
  - hilt
  - jetpack compose
  
Testing strategy
  - business logic only is being unit tested
  
Limitations and recommended extensions
  - clean architecture has not been implemented
  - retrofit service has not been implemented
  - api repository has not been implemented
  - unit testing of view models has not been implemented
  - espresso testing has not been implemented
  
This is a minimum viable product meeting the requirements below:
Minimum Requirements
– Create 2 screens:
– First screen accepts a manual input of a transaction. You have the freedom to add as many input
fields as you see fit
– Second screen displays a list of transactions made on the device. Persisting the transactions is not
needed.
– Reject withdrawals if the user does not have enough money in their account
Example
– Billy deposits $10 > Billy withdraws $10 (ok) > Billy withdraws $5 (error)


What we’re looking for
– Simple and concise code - yes
– A reasonable but scalable architecture - yes
– Proper modelling of the domain - very, very simple model
– A sound testing strategy 
  - rudimentary unit testing of business logic has been implemented
  - it is recommended to add unit testing of view models, mocking retrofit api service (after such service has been implemented)
– A README that will help other developers - yes
