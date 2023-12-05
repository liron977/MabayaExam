# MabayaExam

Liron Kotev
liron.kotev@gmail.com

## DB Connection

Access the H2 database console via [this link](http://localhost:8080/h2-console/login.jsp?jsessionid=93333441b811bcf1004f46290f6a9efa).

**Connection Details:**
- Saved Settings: Generic H2(Embedded)
- Setting Name: Generic H2(Embedded)
- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa

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

## Serve Ad

Use the following API to retrieve ads:

curl --location 'http://localhost:8080/api/ad/serve?category=Clothing'


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


