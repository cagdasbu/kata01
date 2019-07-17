# KATA 01 - Assesment Approach

This repository represents a modelling approach to the problem given in
http://codekata.com/kata/kata01-supermarket-pricing/

General domain defined as *SuperMarket* and *campaign*, *product*, and *checkout* are following. The *Checkout* behaviour has been completed via following steps;
1. *ShoppingCart* aggregates the items in different phases (CartItem and CheckoutItem)
2. *ShoppingCart* orchestrates the checkout operation

## Installation

Repo using maven as package manager. You can simply build via;

```mvn clean package```

## Testing
Since no frameworks have been used, a small interaction logic implemented which can be run;

```mvn exec:java -Dexec.mainClass="com.novacode.supermarket.KataMarket" -Dexec.args="1:3 2:2 3:0.2"```