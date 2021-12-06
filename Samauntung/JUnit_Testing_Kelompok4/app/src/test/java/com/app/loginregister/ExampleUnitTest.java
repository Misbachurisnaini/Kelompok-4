package com.app.loginregister;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTestSampleJava {
    private static final String FAKE_STRING = "HELLO_WORLD";
    private Context context = ApplicationProvider.getApplicationContext();

    @Test
    public void readStringFromContext_LocalizedString() {
        // Given a Context object retrieved from Robolectric...
        LoginActivity myObjectUnderTest = new LoginActivity(context);

        // ...when the string is returned from the object under test...
        String result = LoginActivity.getHelloWorldString();

        // ...then the result should be the expected one.
        assertThat(result).isEqualTo(FAKE_STRING);
    }

    private void assertThat(String result) {

    }
}
