https://www.kaggle.com/c/acquire-valued-shoppers-challenge/data

This data captures the process of offering incentives (a.k.a. coupons) to a large number of customers and forecasting those who will become loyal to the product. Let's say 100 customers are offered a discount to purchase two bottles of water. Of the 100 customers, 60 choose to redeem the offer. These 60 customers are the focus of this competition. You are asked to predict which of the 60 will return (during or after the promotional period) to purchase the same item again.

To create this prediction, you are given a minimum of a year of shopping history prior to each customer's incentive, as well as the purchase histories of many other shoppers (some of whom will have received the same offer). The transaction history contains all items purchased, not just items related to the offer. Only one offer per customer is included in the data. The training set is comprised of offers issued before 2013-05-01. The test set is offers issued on or after 2013-05-01.

Files

You are provided four relational files:

transactions.csv - contains transaction history for all customers for a period of at least 1 year prior to their offered incentive
trainHistory.csv - contains the incentive offered to each customer and information about the behavioral response to the offer
testHistory.csv - contains the incentive offered to each customer but does not include their response (you are predicting the repeater column for each id in this file)
offers.csv - contains information about the offers
Fields

All of the fields are anonymized and categorized to protect customer and sales information. The specific meanings of the fields will not be provided (so don't bother asking). Part of the challenge of this competition is learning the taxonomy of items in a data-driven way.

history
id - A unique id representing a customer
chain - An integer representing a store chain
offer - An id representing a certain offer
market - An id representing a geographical region
repeattrips - The number of times the customer made a repeat purchase
repeater - A boolean, equal to repeattrips > 0
offerdate - The date a customer received the offer

transactions
id - see above
chain - see above
dept - An aggregate grouping of the Category (e.g. water)
category - The product category (e.g. sparkling water)
company - An id of the company that sells the item
brand - An id of the brand to which the item belongs
date - The date of purchase
productsize - The amount of the product purchase (e.g. 16 oz of water)
productmeasure - The units of the product purchase (e.g. ounces)
purchasequantity - The number of units purchased
purchaseamount - The dollar amount of the purchase

offers
offer - see above
category - see above
quantity - The number of units one must purchase to get the discount
company - see above
offervalue - The dollar value of the offer
brand - see above

The transactions file can be joined to the history file by (id,chain). The history file can be joined to the offers file by (offer). The transactions file can be joined to the offers file by (category, brand, company). A negative value in productquantity and purchaseamount indicates a return.
