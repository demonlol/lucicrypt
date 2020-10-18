# lucicrypt
Simple encryption code made in java

~~Works by tweaking the character codes. Very simple and should never be used for production use.~~
Edit: Nevermind I thought this was an older version.

This code is a little more complex and changes need done. It works by assigning a **buffer byte** to the next 8 bytes which I call a **byte sequence**. The sequence contains characters that are and aren't used for decryption. The only way you can identify which characters are used is with the buffer byte (which explains why there are 9 bytes in a sequence).

# example code

```java
import lamaze.lucicrypt.Lucicrypt;

public class Main {

    public static void main(String[] args) {
        String message = "This is an example message! 123 !@#$%^&*()";
        String in = Lucicrypt.encrypt(message);
        String out = Lucicrypt.decrypted(in);

        System.out.printf("Plain Message: '%s'\nEncrypted: '%s'\nDecrypted: '%s'", message, in, out);
    }

}
```

# output
```
Plain Message: 'This is an example message! 123 !@#$%^&*()'
Encrypted: 'j$ndÁmYAÝi\n°n%ÒT\xs°j%Nò`gkÚPrÉýb\nnjr%xó3,&jÄNb`.'ë7sá;c& ðcÁ0_#è%!¡c .æö'
Decrypted: 'This is an example message! 123 !@#$%^&*()'
```

**TODO**
 - Levels of encryption
 - Key based encryption
