A]
// procedure to add users

delimiter //
create procedure add_user(User_Name varchar(25),Mobile_No int,Email_ID varchar(25),Password varchar(25))
begin
insert into User(User_Name,Mobile_No,Email_ID,Password)
values(User_Name,Mobile_No,Email_ID,Password);
end //
delimiter ;

drop procedure add_user;

B]
// procedure to add sellers

delimiter //
create procedure add_sellers(Company_Name varchar(25),Product_Category varchar(25),Payment_Preffered varchar(25))
begin
insert into Sellers(Company_Name,Product_Category,Payment_Preffered)
values(Company_Name,Product_Category,Payment_Preffered);
end //
delimiter ;

drop procedure add_sellers;

C]

// procedure to add products

delimiter //
create procedure add_products(Name varchar(25),Base_Price int,Sold_At int,Status varchar(10))
begin
insert into product(Name,Base_Price,Sold_At,Status)
values(Name,Base_Price,Sold_At,Status);
end //
delimiter ;


drop procedure add_products;


D]

// procedure to add Buyers

delimiter //
create procedure add_Buyers(Address varchar(25),PIN_code int,Product varchar(25),Bid_Amt int)
begin
insert into Buyers(Address,PIN_code,Product,Bid_Amt)
values(Address,PIN_code,Product,Bid_Amt);
end //
delimiter ;


drop procedure add_products;


E]

// Trigger on Auction Table (Before Update)

create trigger update_Auction
before update on Auction
for each row
set new.SID = old.SID + 1, new.PID old.PID + 1;




