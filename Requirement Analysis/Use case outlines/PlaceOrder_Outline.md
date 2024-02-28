# Place Order Use Case

## Basic Flow

1. Customer reviews the cart and selects products.
2. Customer requests to place an order.
3. Software checks inventory availability successfully (inventory is sufficient).
4. Software asks customer to set up delivery information.
5. Customer enters delivery information correctly.
6. Software calculates delivery fee and total product price.
7. Software displays and temporarily saves invoice information.
8. Customer chooses the usual delivery method.

(Steps 9-13 are steps in the basic flow of "Pay for the order" use case)

9. Customer selects payment method supported by VNPay.
10. Customer provides the necessary information as requested by VNPay to successfully complete the transaction.
11. Software confirms transaction and displays transaction details.
12. Software sends all order and transaction information to customer's email.
13. Software records the transaction information and the successfully paid order.

## Alternative Flow

(Steps in the basic flow of "Select rush order delivery" use case)

8a. Customer selects rush order delivery method.

8a1. Software checks eligibility for rush order delivery successfully.

8a2. Software requests additional rush order delivery information from the customer and provides other information.

8a3. Customer provides rush order delivery details.

8a4. Software recalculates the delivery fees and updates the corresponding invoice.

Continue to step 9.
