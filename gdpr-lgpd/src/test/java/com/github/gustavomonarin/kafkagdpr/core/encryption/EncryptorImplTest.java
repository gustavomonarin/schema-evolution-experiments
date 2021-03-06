package com.github.gustavomonarin.kafkagdpr.core.encryption;

import com.github.gustavomonarin.kafkagdpr.core.encryption.materials.SymmetricMaterial;
import com.github.gustavomonarin.kafkagdpr.core.encryption.providers.DecryptingMaterialsProvider;
import com.github.gustavomonarin.kafkagdpr.core.encryption.providers.EncryptingMaterialsProvider;
import org.junit.jupiter.api.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

class EncryptorImplTest {

    @Test
    void encrypt() throws NoSuchAlgorithmException {

        //given
        byte[] toBeEncrypted = "toBeEncrypted".getBytes();

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();

        EncryptingMaterialsProvider encProvider = (s) -> new SymmetricMaterial(secretKey);
        DecryptingMaterialsProvider decProvider = (s) -> new SymmetricMaterial(secretKey);

        Encryptor encryptor = new EncryptorImpl(encProvider);
        Decryptor decryptor = new DecryptorImpl(decProvider);


        //When
        EncryptedData encrypted = encryptor.encrypt("", toBeEncrypted);
        byte[] decrypted = decryptor.decrypt("", encrypted);

        //Then
        assertThat(toBeEncrypted).isNotEqualTo(encrypted.data());

        assertThat(decrypted).isEqualTo(toBeEncrypted);
    }
}