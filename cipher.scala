def encrypt(text: String, shift: Int): String = {
    text.map(c => {
        if (c.isLetter) {
            val newAscii = c.toInt + shift
            val base = if (c.isUpper) 'A'.toInt else 'a'.toInt
            ((newAscii - base) % 26 + base).toChar
        } else c
    })
}

def decrypt(text: String, shift: Int): String = {
    encrypt(text, 26 - shift)
}

def cipher(operation: (String, Int) => String, text: String, shift: Int): String = {
    operation(text, shift)
}

@main def main() = {
    val originaltext = "ABCD abcd"
    val shift = 3
    val encryptedtext = cipher(encrypt, originaltext, shift)
    println(encryptedtext)
    val decryptedtext = cipher(decrypt, encryptedtext, shift)
    println(decryptedtext)
}