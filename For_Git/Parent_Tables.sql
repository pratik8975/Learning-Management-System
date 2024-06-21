A]
                            desc;
+-----------+--------------+------+-----+---------+----------------+
| Field     | Type         | Null | Key | Default | Extra          |
+-----------+--------------+------+-----+---------+----------------+
| ID        | int          | NO   | PRI | NULL    | auto_increment |
| User_Name | varchar(100) | YES  |     | NULL    |                |
| Mobile_No | varchar(100) | YES  |     | NULL    |                |
| Email_ID  | varchar(40)  | YES  |     | NULL    |                |
| Password  | varchar(50)  | YES  |     | NULL    |                |
+-----------+--------------+------+-----+---------+----------------+

                             users table;
+---------+-----------------+------------+----------------------------+----------+
|     ID  | User_Name       | Mobile_No  | Email_ID                   | Password |
+---------+-----------------+------------+----------------------------+----------+
|    1011 | PRIYA GUPTA     | 9881232333 | priya.patel84@gmail.com    | *****    |
|    1012 | ANUJ SHARMA     | 9881232334 | anuj.kra@gmail.com         | *****    |
|    1013 | KAVITA VERMA    | 8749012534 | vikas.kavita76@gmail.com   | *****    |
|    1014 | DEEP MANOHAR    | 6905824137 | manohar.kumar95@gmail.com  | *****    |
|    1015 | ADITI PATEL     | 2073968510 | rahul.aditi77@gmail.com    | *****    |
|    1016 | MANISH SHAH     | 9310428576 | manish.sharma81@gmail.com  | *****    |
|    1017 | ARJUN KAPOOR    | 6240371895 | shilpa.arjun91@gmail.com   | *****    |
|    1018 | SANYA MALHOTRA  | 3589104726 | sanya.malh34@gmail.com     | *****    |
|    1019 | NISHA DESAI     | 5793184206 | nisha.singh21@gmail.com    | *****    |
|    1020 | RAJIV MEHTA     | 8652014793 | rajiv.42@gmail.com         | *****    |
|    1021 | AARTI REDDY     | 7329164058 | t.reddy53@gmail.com        | *****    |
|    1022 | SAMEER BHATIA   | 8962741305 | bya.s08@gmail.com          | *****    |
|    1023 | AANAND JOSHI    | 4013596827 | aanand.p13@gmail.com       | *****    |
|    1024 | RITU SINGHANIA  | 6289170453 | ritu.mishra26@gmail.com    | *****    |
|    1025 | KARAN MALIK     | 9732608415 | karan.malik29@gmail.com    | *****    |
|    1026 | VIVEK CHAVAN    | 5827936104 | vivek.sh12@gmail.com       | *****    |
|    1027 | RISHIKESH JOSHI | 7395482106 | mar.joshi88@gmail.com      | *****    |
|    1028 | DARSHAN SHINDE  | 2560938714 |  kavita.shinde06@gmail.com | *****    |
|    1029 | ANIKET RATHOD   | 9183047562 | ani.rath64@gmail.com       | *****    |
|    1030 | AKSHAY POTDAR   | 9183047566 |  akshay.lal56@gmail.com    | *****    |
|    1031 | SUMIT SHAH      | 3051824976 | sumit.shah32@gmail.com     | *****    |
|    1032 | AMEY TARE       | 6749123850 | amey.kar17@gmail.com       | *****    |
|    1033 | ANMOL WAGH      | 3102974865 | anmol.waghl73@gmail.com    | *****    |
|    1034 | YAMUNA SHROTRI  | 8475610392 | yamuna.bhatia09@gmail.com  | *****    |
|    1035 | RAMESH OSWAL    | 7028149653 | ramesh-oswal79@gmail.com   | *****    |
|    1036 | AADITYA NAVALE  | 9174205386 | aadi.navale48@gmail.com    | *****    |
|    1037 | MINAKSHI KAPOOR | 2396850741 | mk@gmail.com               | *****    |
|    1038 | AVNTIKA KARPE   | 7916345802 | avnti.rai67@gmail.com      | *****    |
|    1039 | GOPAL SHARMA    | 9732608415 | gopals@gmial.com           | *****    |
|    1040 | SONALI JOSHI    | 9052876394 | IamSonali@gmail.com        | *****    |
|    1041 | RAJ BODKE       | 9765767876 | IamRaj@gmail.com           | *****    |
|    1042 | TANMAY ARSHAD   | 9076875676 | Tanmay@gmail.com           | *****    |
|    1043 | RAHUL YADAV     | 9387675634 | R.Yadav@gmail.com          | *****    |
|    1044 | KULDEEP YADAV   | 9287678989 | KulYadav@gmail.com         | *****    |
|    1045 | SACHIN SAHANI   | 7898675645 | IamSachin@gmail.com        | *****    |
|    1046 | TRUPTI SAWARE   | 8898765456 | Trupts@gmail.com           | *****    |
|    1047 | SAYALI MANE     | 9789989878 | ManeS@gmail.com            | *****    |
|    1048 | TRUPTI MANE     | 9689894521 | TMane@gmail.com            | *****    |
|    1049 | AVDHUT GUPTE    | 9065234545 | Gupte@gmail.com            | *****    |
|    1050 | RAJ SHARMA      | 9732455556 | RajS@gmail.com             | *****    |
+---------+-----------------+------------+----------------------------+----------+



B]
                              desc;
+-------------------+-------------+------+-----+---------+----------------+
| Field             | Type        | Null | Key | Default | Extra          |
+-------------------+-------------+------+-----+---------+----------------+
| ID                | int         | NO   | PRI | NULL    | auto_increment |
| Company_Name      | varchar(25) | NO   |     | NULL    |                |
| Product_Category  | varchar(25) | YES  |     | NULL    |                |
| Payment_Preffered | varchar(25) | YES  |     | NULL    |                |
+-------------------+-------------+------+-----+---------+----------------+

                         sellers table;
+-----+--------------+----------------------+-------------------+
| ID  | Company_Name | Product_Category     | Payment_Preffered |
+-----+--------------+----------------------+-------------------+
| 101 | Astra        | Painting             | UPI               |
| 102 | Regency      | Musical_Instrument   | Cash              |
| 103 | Star         | Antiques             | Cheque/RTGS       |
| 104 | Dove         | Rare_Stones          | Cheque/RTGS       |
| 105 | KSG          | Ancient_Civilisation | Any               |
| 106 | Dwell        | Hand_Made_Crafts     | Cash              |
| 107 | Aura         | Biodiversity         | NEFT/RTGS         |
| 108 | Holt         | Recycled_Art         | DD                |
| 109 | VJ           | Real_Estate          | Cheque/NEFT       |
| 110 | Venus        | Jewellery            | UPI               |
+-----+--------------+----------------------+-------------------+




C]
                             desc;
+------------+-------------+------+-----+---------+----------------+
| Field      | Type        | Null | Key | Default | Extra          |
+------------+-------------+------+-----+---------+----------------+
| ID         | int         | NO   | PRI | NULL    |                |
| SID        | int         | NO   | MUL | NULL    | auto_increment |
| Name       | varchar(25) | YES  |     | NULL    |                |
| Base_Price | int         | YES  |     | NULL    |                |
| Sold_At    | int         | YES  |     | NULL    |                |
| Status     | varchar(10) | YES  |     | NULL    |                |
+------------+-------------+------+-----+---------+----------------+


                         products table;
+-----+-----+--------------------------+------------+---------+--------+
| ID  | SID | Name                     | Base_Price | Sold_At | Status |
+-----+-----+--------------------------+------------+---------+--------+
| 301 | 101 | Burning_Statue           |      63000 |   87000 | SOLD   |
| 302 | 102 | Lute                     |     110000 |  155700 | SOLD   |
| 303 | 103 | Vase                     |      75000 |   87600 | SOLD   |
| 304 | 104 | Turquoise                |      70000 |   81380 | SOLD   |
| 305 | 105 | Pots                     |      98000 |  128000 | SOLD   |
| 306 | 106 | Wooden_Case              |      25000 |       0 | UNSOLD |
| 307 | 107 | Dinosaur_Fossil          |    1590000 | 2236000 | SOLD   |
| 308 | 108 | Plastic_Dragonfly        |      35000 |       0 | UNSOLD |
| 309 | 109 | Trinity_Bungalow         |    7500000 | 9203400 | SOLD   |
| 310 | 110 | Sirsajala(Pearl_Hairnet) |     540000 | 1263000 | SOLD   |
+-----+-----+--------------------------+------------+---------+--------+




D]
                            desc;
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| ID         | int         | NO   | PRI | NULL    |       |
| SID        | int         | YES  | MUL | NULL    |       |
| Life       | varchar(25) | NO   |     | NULL    |       |
| Weight     | varchar(25) | YES  |     | NULL    |       |
| Start_Time | varchar(20) | YES  |     | NULL    |       |
| End_Time   | varchar(20) | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+

                       category table;
+-----+------+------------------+----------+------------+----------+
| ID  | SID  | Life             | Weight   | Start_Time | End_Time |
+-----+------+------------------+----------+------------+----------+
|  11 |  101 | 78 years old     | 9 kgs    | 10 AM      | 11 AM    |
|  22 |  102 | 13th Century     | 1.5 kgs  | 11.30 AM   | 12.30 PM |
|  33 |  103 | 16th Century     | 5.8 kgs  | 01 PM      | 02 PM    |
|  44 |  104 | 3200 B.C.        | 2 grams  | 02.30 PM   | 03.30 PM |
|  55 |  105 | 4th Century      | 4 kgs    | 04 PM      | 05 PM    |
|  66 |  106 | 19th Century     | 12 kgs   | 05 PM      | 05.30 PM |
|  77 |  107 | 66 million years | 5762 kgs | 05.30 PM   | 06 PM    |
|  88 |  108 | 7 Months         | 166 kgs  | 06.30 PM   | 07 PM    |
|  99 |  109 | 22 years         | NA       | 07 PM      | 07.30 PM |
| 111 |  110 | 11th Century     | 1.2 kgs  | 08 PM      | 09 PM    |
+-----+------+------------------+----------+------------+----------+




E]
                           desc;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| User_ID   | int         | YES  | MUL | NULL    |       |
| PID       | int         | YES  | MUL | NULL    |       |
| Name      | varchar(50) | YES  |     | NULL    |       |
| Bid_Amt   | int         | YES  |     | NULL    |       |
| User_Name | varchar(20) | YES  |     | NULL    |       |
| Bid_Time  | varchar(10) | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+




                        bidders table;
+---------+------+--------------------------+---------+-----------------+----------+
| User_ID | PID  | Name                     | Bid_Amt | User_Name       | Bid_Time |
+---------+------+--------------------------+---------+-----------------+----------+
|    1011 |  301 | Burning_Statue           |   87000 | PRIYA GUPTA     | 10:30 AM |
|    1014 |  302 | Lute                     |  155700 | DEEP MANOHAR    | 12:00 AM |
|    1019 |  303 | Vase                     |   87600 | NISHA DESAI     | 08:00 PM |
|    1037 |  304 | Turquoise                |   81380 | MINAKSHI KAPOOR | 01:28 PM |
|    1022 |  305 | Pots                     |  128000 | SAMEER BHATIA   | 04:16 PM |
|    1024 |  307 | Dinosaur_Fossil          | 2236000 | RITU SINGHANIA  | 06:45 PM |
|    1040 |  309 | Trinity_Bungalow         | 9203400 | SONALI JOSHI    | 07:42 PM |
|    1027 |  310 | Sirsajala(Pearl_Hairnet) | 1263000 | RISHIKESH JOSHI | 08:19 PM |
|    1012 |  301 | Burning_Statue           |   78000 | ANUJ SHARMA     | 01:30 PM |
|    1013 |  301 | Burning_Statue           |   81000 | KAVITA VERMA    | 02:00 PM |
|    1015 |  302 | Lute                     |  152400 | ADITI PATEL     | 12:30 PM |
|    1016 |  302 | Lute                     |  100000 | MANISH SHAH     | 03:00 PM |
|    1017 |  302 | Lute                     |   95000 | ARJUN KAPOOR    | 02:30 PM |
|    1018 |  303 | Vase                     |   78000 | SANYA MALHOTRA  | 03:30 PM |
|    1021 |  304 | Turquoise                |   80888 | AARTI REDDY     | 06:00 PM |
|    1023 |  304 | Turquoise                |   80000 | AANAND JOSHI    | 07:30 PM |
|    1025 |  305 | Pots                     |  112500 | KARAN MALIK     | 08:45 PM |
|    1026 |  305 | Pots                     |  121000 | VIVEK CHAVAN    | 06:45 PM |
|    1028 |  307 | Dinosaur_Fossil          | 2135000 | DARSHAN SHINDE  | 11:45 AM |
|    1029 |  307 | Dinosaur_Fossil          | 2056000 | ANIKET RATHOD   | 12:40 PM |
|    1030 |  309 | Trinity_Bungalow         | 9005455 | AKSHAY POTDAR   | 10:45 AM |
|    1044 |  309 | Trinity_Bungalow         | 8852456 | KULDEEP YADAV   | 10:36 AM |
|    1045 |  310 | Sirsajala(Pearl_Hairnet) | 1132000 | SACHIN SAHANI   | 08:20 PM |
|    1046 |  310 | Sirsajala(Pearl_Hairnet) | 1025600 | TRUPTI SAWARE   | 08:36 PM |
|    1047 |  310 | Sirsajala(Pearl_Hairnet) | 1261000 | SAYALI MANE     | 08:23 PM |
+---------+------+--------------------------+---------+-----------------+----------+




F]
                           desc;
+----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| User_ID  | int          | YES  | MUL | NULL    |       |
| Address  | varchar(30)  | YES  |     | NULL    |       |
| PIN_code | int          | YES  |     | NULL    |       |
| Product  | varchar(200) | YES  |     | NULL    |       |
| Bid_Amt  | int          | YES  |     | NULL    |       |
+----------+--------------+------+-----+---------+-------+



                       buyers table;
+---------+------------+----------+--------------------------+---------+
| User_ID | Address    | PIN_code | Product                  | Bid_Amt |
+---------+------------+----------+--------------------------+---------+
|    1011 | Pune       |   411001 | Burning_Statue           |   87000 |
|    1014 | Kharadi    |   412803 | Lute                     |  155700 |
|    1019 | Thane      |   144003 | Vase                     |   87600 |
|    1037 | Goa        |   442101 | Turquoise                |   81380 |
|    1022 | AhmedNagar |   400606 | Pots                     |  128000 |
|    1024 | Bandra     |   640001 | Dinosaur_Fossil          | 2236000 |
|    1040 | Pune       |   143008 | Trinity_Bungalow         | 9203400 |
|    1027 | Nashik     |   428002 | Sirsajala(Pearl_Hairnet) | 1263000 |
+---------+------------+----------+--------------------------+---------+






G]
                          desc;
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| SID        | int         | YES  | MUL | NULL    |       |
| PID        | int         | YES  | MUL | NULL    |       |
| Date       | date        | YES  |     | NULL    |       |
| Start_Time | varchar(20) | YES  |     | NULL    |       |
| End_Time   | varchar(20) | YES  |     | NULL    |       |
| Total_Bids | int         | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+


                       auction table;
+------+------+------------+------------+-----------+------------+
| SID  | PID  | Date       | Start_Time | End_Time  | Total_Bids |
+------+------+------------+------------+-----------+------------+
|  101 |  301 | 2023-03-12 | 10:00 AM   | 11:00 AM  |          3 |
|  102 |  302 | 2023-03-12 | 11:30 AM   | 12:30 AM  |          4 |
|  103 |  303 | 2023-03-12 | 01:00 PM   | 02:00 PM  |          2 |
|  104 |  304 | 2023-03-12 | 02:30 PM   | 03:30 PM  |          4 |
|  105 |  305 | 2023-03-12 | 04:00 PM   | 05:00 PM  |          3 |
|  106 |  306 | 2023-03-12 | 05:00 PM   | 05:30 PM  |          0 |
|  107 |  307 | 2023-03-12 | 05:30 PM   | 06:00 PM  |          3 |
|  108 |  308 | 2023-03-12 | 06:30 PM   | 07:00 PM  |          0 |
|  109 |  309 | 2023-03-12 | 07:00 PM   | 07:30 PM  |          3 |
|  110 |  310 | 2023-03-12 | 08:00 PM   | 09:00 PM  |          4 |
+------+------+------------+------------+-----------+------------+



H]

                          desc;
+------------------+-------------+------+-----+---------+-------+
| Field            | Type        | Null | Key | Default | Extra |
+------------------+-------------+------+-----+---------+-------+
| SID              | int         | YES  | MUL | NULL    |       |
| PID              | int         | YES  | MUL | NULL    |       |
| TID              | varchar(50) | NO   |     | NULL    |       |
| Seller_Acc       | varchar(50) | NO   |     | NULL    |       |
| Payment_Date     | varchar(20) | YES  |     | NULL    |       |
| Sold_At          | int         | YES  |     | NULL    |       |
| Delivery_Charges | varchar(10) | YES  |     | NULL    |       |
+------------------+-------------+------+-----+---------+-------+


                        payment table;
+------+------+---------------+-------------+--------------+---------+------------------+
| SID  | PID  | TID           | Seller_Acc  | Payment_Date | Sold_At | Delivery_Charges |
+------+------+---------------+-------------+--------------+---------+------------------+
|  101 |  301 | T760093736989 | 34039781259 | 2023-03-13   |   87000 | 5000             |
|  102 |  302 | T458964780254 | 78025969981 | 2023-03-15   |  155700 | 700              |
|  103 |  303 | T100236974520 | 25120036025 | 2023-03-13   |   87600 | 850              |
|  104 |  304 | T460315089258 | 25123602523 | 2023-03-18   |   81380 | 200              |
|  105 |  305 | T987205877855 | 32012615106 | 2023-03-20   |  128000 | 1500             |
|  107 |  307 | T127889228007 | 72184860642 | 2023-03-14   | 2236000 | 4500             |
|  109 |  309 | T436911020388 | 00256348963 | 2023-03-15   | 9203400 | NA               |
|  110 |  310 | T436911020388 | 00256348963 | 2023-03-16   | 1263000 | 3500             |
+------+------+---------------+-------------+--------------+---------+------------------+
-------------------------------------------------------------------------------------------------------

I]

                        desc;
+---------+--------------+------+-----+---------+-------+
| Field   | Type         | Null | Key | Default | Extra |
+---------+--------------+------+-----+---------+-------+
| User_ID | int          | YES  | MUL | NULL    |       |
| PID     | int          | YES  | MUL | NULL    |       |
| CID     | int          | YES  |     | NULL    |       |
| Message | varchar(120) | YES  |     | NULL    |       |
+---------+--------------+------+-----+---------+-------+


                  notification table;
+---------+------+------+-----------------------------------------------------------------------------------+
| User_ID | PID  | CID  | Message                                                                           |
+---------+------+------+-----------------------------------------------------------------------------------+
|    1011 |  301 |   11 | Thank you for doing business with us your product will be delivered on 2023-03-17 |
|    1014 |  302 |   22 | Thank you for doing business with us your product will be delivered on 2023-03-20 |
|    1019 |  303 |   33 | Thank you for doing business with us your product will be delivered on 2023-03-21 |
|    1037 |  304 |   44 | Thank you for doing business with us your product will be delivered on 2023-03-23 |
|    1022 |  305 |   55 | Thank you for doing business with us your product will be delivered on 2023-03-25 |
|    1024 |  307 |   77 | Thank you for doing business with us your product will be delivered on 2023-03-18 |
|    1040 |  309 |   99 | Thank you for doing business with us                                              |
|    1027 |  310 |  111 | Thank you for doing business with us your product will be delivered on 2023-03-22 |
+---------+------+------+-----------------------------------------------------------------------------------+
---------------------------------------------------------------------------------------------------------





















