# lucicrypt
Simple encryption code made in java

~~Works by tweaking the character codes. Very simple and should never be used for production use.~~
Edit: Nevermind I thought this was an older version.

This code is a little more complex and changes need done. It works by assigning a **buffer byte** to the next 8 bytes which I call a **byte sequence**. The sequence contains characters that are and aren't used for decryption. The only way you can identify which characters are used is with the buffer byte (which explains why there are 9 bytes in a sequence).

**TODO**
 - Levels of encryption
 - Key based encryption
