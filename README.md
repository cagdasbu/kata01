# KATA 01 - Assessment Approach

This repository represents a modelling approach to the problem given in
http://codekata.com/kata/kata01-supermarket-pricing/

General domain defined as *SuperMarket* and *campaign*, *product*, and *checkout* are following. The *Checkout* behaviour has been completed via following steps;
1. *ShoppingCart* aggregates the items in different phases (CartItem and CheckoutItem)
2. *ShoppingCart* orchestrates the *checkout* operation

## Installation

Repo using maven as package manager. You can simply build via;

```mvn clean package```

## Testing
Since no frameworks have been used, a very primitive interaction logic implemented which the problem case bill scenario can be run;

```mvn exec:java -Dexec.mainClass="com.novacode.supermarket.KataMarket" -Dexec.args="B:3 C:2 O:0.2"```

* B represents Beans
* C represents Coke
* O represents Oranges

Campaing details has been implemented as the scenario defined in CampaignManager, not editable;
 
 1. B has been registered to campaign `3 Beans for 2 price`
 2. C has been registered to campaign `2 Cokes for £1`
 
