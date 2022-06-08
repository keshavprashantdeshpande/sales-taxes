# sales-taxes
The main aim of this project is to complete the task of calculation the sales tax for the given list of items purchased.
# Use cases
Before moving on to the actual design first I decided to go through some use cases so that it becomes easy to understand the scope of the project and the scope of the design document.
Here are some typical use cases which a particular user of the system will be able to perform
1. Add new kind of product in the system
2. Calculate sales tax of the product list. If the product is imported add the tax rate accordingly
3. Create a shopping basket which has the price of the items along with other details
4. Calculate and print the final amount of the shopping basket

For the first phase of the design document only the typical use cases were considered
# Design decisions
As the GUI was out of scope in the first phase it was decided to go for a standalone project in java with spring boot. Spring boot repository was created using the springinitializer. Build tool used was maven. Lombok dependency was added to make the development easy.

A typical 2 dimensional layered architecture was followed to come up with the architecture for the application.

Decoupling layers: Service layer was used to store the application-specific business rules, model, exception, config were used for the named purpose.

Decoupling use cases: Based on the typical use cases of the system, I decided to create group of use cases as follows: order, product, productfactory, file, taxrate, taxcalculator and the util package.

Design patterns: 
1. To accommodate the part of the product using which we can easily add and create groups of product, I decided to use the factory pattern
2. Changing nature of the tax rate along with the requirement to adjust some additional duties, called for the use of decorator pattern for the tax rates used
