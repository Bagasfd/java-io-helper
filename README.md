# Documentation

## Recruitment

  ```java
    json-simple-1.1.1.jar
 ```
masukan library kedalam projects structure

## How To Use
1.initialisasi package
 ```java
    public class main {
      public static void main(String[] args) {
          io_util utilHelper = new io_util(); //cara intialisasi
      }
    }
 ```
    
2.method buat file

parameter :
```java
 utilHelper.tulisFile(text,path);
```
(String)text : isi text dari file

(String)path : lokasi dimana file akan di buat

return : (tidak mereturn apapun)
```java
public class main {
    public static void main(String[] args) {
        io_util utilHelper = new io_util();
        try {
         utilHelper.tulisFile("ini akan di tulius kedalam file","/Users/bagasfadillah/IdeaProjects/MyPorjects/src/config.properties");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
```

3.method baca properties

parameter :
```java
    Map fileProperties =  utilHelper.bacaFileProperties(path);
```

(String)path : lokasi file yang ingin di baca

return : Map
```java
public class main {
    public static void main(String[] args) {
        io_util utilHelper = new io_util();
        try {
          Map fileProperties =  utilHelper.bacaFileProperties("path");
          String port = (String) fileProperties.get("PORT");
          String server = (String) fileProperties.get("SERVER");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
```

4.method bacaFile

parameter:
```java
 String isiFile = utilHelper.bacaFile(type,lineStart,path);
```

(String)type : "string","jsonArray" pilih salah satu

(int)lineStart : membaca file mulai dari baris keberapa ? baris di hitung mulai dari 0

(String) path : lokasi file yang ingin dibaca

return : String

```java
public class main {
    public static void main(String[] args) {
        io_util utilHelper = new io_util();
        try {
            String isiFile = utilHelper.bacaFile("jsonArray",1,"/Users/bagasfadillah/IdeaProjects/MyPorjects/src/config.properties");
            System.out.println(isiFile);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
```

