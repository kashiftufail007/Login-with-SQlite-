# Login-with-SQlite-:heart: :1st_place_medal::heart:
Login Registration SQlite Detail 

#### Here in this project you can store your Data in SQLite through Registration and then use this data as login, :collision:
#### Easily Changeable and highly understandable Code  :thumbsup::heart:
<p align="center">
  <img width="300"  src="https://user-images.githubusercontent.com/34978760/61577357-c6311a80-aaff-11e9-8dfe-795e6d9e99e9.gif">
</p>

## Project Detail 

### DataBaseHelper Activity for SQite Database detail :heart::slightly_smiling_face: :relaxed:

```java
Create table user_detail(serial_number INTEGER  PRIMARY KEY AUTOINCREMENT, user_id INTEGER   , email_address text , user_password text, user_status INTEGER "
```

#### To insert in SQLite :writing_hand:

```java
public  void insert (Integer user_id , String email_address , String user_password, Integer user_status) 

```

#### To get all Data from  SQLite :writing_hand:

```java
public Cursor alldata() 
```

### <mark>MainAvtivity for Registation</mark> 
#### Only Insert into  SQLite if Both PASSWORDS matched and EMAIL not exist:writing_hand:

```java
 if (s1.equals("" )|| s2.equals("") || s3.equals(""))  { 

               Toast.makeText(getApplicationContext(), "Fill upper Fields First ", Toast.LENGTH_SHORT).show();                

            }else if(!s2.toString().equals( s3.toString())) {

                Toast.makeText(getApplicationContext(), "Password Does not match", Toast.LENGTH_SHORT).show();

           }else {

                    Boolean check_email = db.check_email(s1);
                    if (check_email == false){
                        Toast.makeText(getApplicationContext(), "Email Already Exists ", Toast.LENGTH_SHORT).show();

                    }else

                        Toast.makeText(getApplicationContext(), "New User Added ", Toast.LENGTH_SHORT).show();

                        db.insert(0, s1, s2, 1 );
            }  
 ```             
### SecondAtivity For View Data :writing_hand:

```java
Cursor cursor = db.alldata(); 
```


### LoginActivity for Login :relaxed:

#### Get Values one by one and Compare IF Condition :writing_hand:
```java
for (int i=0 ; i<cursor.getCount();i++)
 
 if ((ema.equals(cursor.getString(2).toString())) && (pass.equals(cursor.getString(3).toString())))
```

### Author

### Muhammad Kashif  :heart:

* [GitHub Profile](https://github.com/kashiftufail007)
* [Facebook Profile](https://www.facebook.com/KashifCache)
* [LinkedIn Profile](https://www.linkedin.com/in/muhammad-kashif007/)

### License

Copyright © 2019-2020, [Muhammad Kashif](https://github.com/kashiftufail007).
Released under the [MIT License](LICENSE).

[More Projects ](https://github.com/kashiftufail007?tab=repositories)  :muscle: :muscle: :muscle:




