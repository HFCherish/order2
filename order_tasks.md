#tasks
1. init project --15 :: 14.44
2. product creation
	2. should return 201 when create a product  (resource.post)  --3
	3. should contain creation uri in header location (resource.post) --5  :: 34
	4. --------------------------------------------------
	3. should have tried to save the creation data into database and should able to get that product after creation. (repo.save, repo.findById) --5 :: 10
	4. should that one product's id is the same as the created one (resourc.post, repo.save, mapper, database, records; repo.findById, mapper) --15 :: 26
	5. should that one product's name, description, price are the same as the created one (resourc.post, repo.save, mapper, records; mapper-findById) --15 :: 1
6. get all products
	1. should return 200 when get products (resource.get) --2 :: 10
	2. should the response body contains at least  one item info (resource.get, record) -- 3 :: 18
	2. should the response body contains uri info (resource.get, record) --3 :: 14
	3. should that item contains id, name, description, price info (resource.get, record) --10 :: 5
	3. --------------------------------------------------
	2. should have tried to search from database and should able to get a least one product if database is not empty (repo.findAll) --5 :: 7
	3. should that one product's id, name, description, price are the same as expected (mapper-findAll) --10 :: 9
	3. --------------------------------------------------
	4. should return empty when no products in db --5 :: 25
6. get some product
	6. should return 200 when get some product (resource.get) --2
	7. should the response body contains uri, id, name, description, price info (resource.get) --5 :: 14
	3. --------------------------------------------------
	4. should return 404 when no products in db --5 :: 5
11. user register
	11. should return 201 when register a new user (resource.post) --2 :: 6
	12. should return 400 when the registered name is not composed of letters and numbers, at least one (resource.post) -- 5 :: 15
	13. should include creation uri in header location (resource.post) --2 :: 3
	3. --------------------------------------------------
	14. should have tried to save the user info into database and should able to get a user after registered (repo.findById) --2 :: 15
	16. should the user's id is the same as the saved one. (resourc.post, repo.save, mapper, database, record; repo.findById, mapper) --15 :: 11
	17. should the user's name is the same as the saved one (resourc.post, repo.save, mapper, record; mapper-findById) --8 :: 2
18. order creation
	18. should return 201 when creating an order (resource.post) --2 :: 25
	19. should include the creation uri in header location (resource.post) --2 :: 7 
	3. --------------------------------------------------
	20. should have tried to save the order info into database and should able to get the order after created order (repo.findById) --2 :: 16
	22. should the order's id is the same as the created one (resourc.post, repo.save, mapper, database, record; repo.findById, mapper) --13 :: 60
	23. should the order's name, address, phone are the same as the created one (resourc.post, repo.save, mapper, record; mapper-findById) --13 :: 3
	24. should the order contains at least one order item (repo.findById, record)  --50 :: 180
	25. should the order item's product id is the same as what we bought. (resourc.post, repo.save, mapper, database, record; mapper-findById) --13 :: 7
	26. should the order item's quantity is the same as what we bought, and the item's amount is product.price. (resourc.post, repo.save, mapper, record; mapper-findById) --13 :: 4
	3. --------------------------------------------------
	4. should return 400 when the order contains 0 order item --5 :: 9
	5. should return 400 when the order item doesn't exists --8 :: 6
27. get some order of some user
	28. should return 200 when review some order of some user (resource.get) --8 :: 7
	29. should the response body contain uri info (resource.get) --10 :: 20
 	20. should the response body contain name, address, phone, total\_price, created\_at info (resource.get, record) --20 :: 19
 	21. should the response body contain at least one order_item info (resource.get, record) --15 :: 13
 	22. should the order\_item contain product_id, quantity, amount info (resource.get, record) --5 :: 6
	3. --------------------------------------------------
	30. should the amount of the item in that order is the price when creating order (resourc.post, repo.save, mapper, record; mapper-findById) --15 :: 0
	30. should that order's total price is the sum of items' amounts (mapper-findById, record) --10
	28. should that order has a created date (mapper, record) --2 :: 3
	3. --------------------------------------------------
	4. should return 404 when no order in db --5 :: 5
27. get all orders of some user
	28. should return 200 when review all orders of some user (resource.get) --2 :: 10
	29. should the response body contain at least one order info. (resource.get, record)  --15 :: 7
	29. should the response body contain uri info (resource.get) --5
 	20. should the response body contain name, address, phone, total\_price info (resource.get, record) --5 :: 15
 	21. should the response body not contain order items info - 15 :: 13
	3. --------------------------------------------------
	29. should have tried to fetch all orders from database and should get one order when there's one order in database (repo.findAll) --2 :: 10
	31. should the order's id is the same as the created one (resourc.post, repo.save, mapper, database, record; repo.findAll, mapper) --13
	23. should the order's name, address, phone are the same as the created one (resourc.post, repo.save, mapper, record; repo.findAll, mapper) --13
	27. should the order's total price is the sum of items' amounts (mapper, record; mapper-findAll) --2
	28. should the order has a created date (mapper, record) --2 :: 8
	3. --------------------------------------------------
	4. should the response body contain created\_at info when get all orders successfully -- 2 :: 10
	4. should return empty when no orders in db --10 :: 3
29. create payment
	30. should return 201 when pay (resource.post) --2 ::
	3. --------------------------------------------------
	31. should try to save the payment info into database and should able to get that payment after pay (resourc.post, repo.findByOrderId) --20 :: 20
	32. should the type of that payment is as expected (resourc.post, repo.save, mapper, database, record; repo.findByOrderId, mapper) --13
	33. should the amount of that payment is as expected (resourc.post, repo.save, mapper, record; mapper-findByOrderId) --8
34. get payment of some order
	32. should return 200 when get payment (resourc.get) --10
	33. should the response body include pay type info -- 15 :: 11
	35. should the response body include amount, order_uri & payment uri (resource.get) --12 :: 36
	3. --------------------------------------------------
	33. should try to search that payment in database (repo.findByOrderId) --2
	3. --------------------------------------------------
	34. should the response body include creating date (resoure.get, mapper-findByOrderId, record) --5 :: 6
	4. should return 404 when no payment in db --5 :: 2

#databases
1. product: 
	2. id
	2. name
	3. description
	4. price
2. order:
	3. 	id
	1. user_id
	3. name
	4. address
	5. phone
	7. created_at
	9. pay_state
7. order_items:
	8. order_id
	8. product_id
	9. quantity
	10. amount
10. user:
	11. name
12. payments:
	13. order_id
	8. pay_type
	10. pay_at
	11. pay_amount
12. payTypes:
	13. id
	14. name (CASH, INCREDIT_CARD)

	



