# MabayaExam

Liron Kotev
liron.kotev@gmail.com

## DB Connection

After you run the project,
Access the H2 database console via [this link](http://localhost:8080/h2-console/login.jsp?jsessionid=93333441b811bcf1004f46290f6a9efa).

**Connection Details:**
- Saved Settings: Generic H2(Embedded)
- Setting Name: Generic H2(Embedded)
- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:testdb
- User Name: as

![db](https://github.com/liron977/MabayaExam/assets/75321554/28bd0b60-abc1-4cc0-9cff-8a4357edc452)

![dbtables](https://github.com/liron977/MabayaExam/assets/75321554/036edb0c-7b60-4770-a7c8-e32003c004e3)


## Postman Examples

### Create Campaign

Use the following API to create a campaign:

curl --location 'http://localhost:8080/api/campaigns/create' \
--header 'Content-Type: application/json' \
--data '{
"name": "Summer Sale 3805",
"startDate": "2023-11-25",
"productIds": ["SN4","SN9"],
"bid": 30000
}'


![post](https://github.com/liron977/MabayaExam/assets/75321554/46de6d45-60d7-44c4-9ec9-e72a594d56de)


## Serve Ad

Use the following API to retrieve ads:

curl --location 'http://localhost:8080/api/ad/serve?category=Clothing'

![get](https://github.com/liron977/MabayaExam/assets/75321554/c32e755e-4267-4d3d-bf33-ff716ad3fd75)


## more info

While attempting to enhance the efficiency of the query, I encountered challenges 
during implementation, leading me to decide to remove the modifications. 
However, I'd like to share the original query logic that I was considering. 
Here is its structure :

select SERIAL_NUMBER, TITLE, PRICE, bid, category, category <> 'queryParam'  as is_not_category from
(select *   from product
left join  campaign_product
on product.serial_number = campaign_product.PRODUCT_SERIAL_NUMBER
where CAMPAIGN_ID is not null)
left join CAMPAIGN
on CAMPAIGN.ID = CAMPAIGN_ID
WHERE (start_date >= CURRENT_DATE() - INTERVAL '10' DAY) AND  start_date <= CURRENT_DATE()
order by is_not_category, bid desc
limit 1;


