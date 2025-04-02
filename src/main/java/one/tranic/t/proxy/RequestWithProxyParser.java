package one.tranic.t.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/**
 * A utility class for handling HTTP connections and streams with support for proxy configurations
 * and asynchronous operations.
 * <p>
 * This class provides methods to open URL connections and input streams synchronously or asynchronously,
 * applying proxy settings retrieved automatically from the environment or system configuration.
 */
@SuppressWarnings("unused")
public class RequestWithProxyParser {
    private static Proxy proxy = ProxyConfigReader.getProxy();

    /**
     * Sets a custom proxy for the RequestWithProxyParser class.
     *
     * @param proxy the Proxy instance to be set as the custom proxy. This proxy
     *              will be used for subsequent network requests within this class.
     */
    public static void setCustomProxy(Proxy proxy) {
        RequestWithProxyParser.proxy = proxy;
    }

    /**
     * Refreshes the proxy configuration used by the application.
     * <p>
     * This method retrieves the current proxy settings by invoking the `ProxyConfigReader.getProxy()` method
     * and updates the static `proxy` field with the newly retrieved proxy configuration.
     * It is useful in scenarios where the proxy settings might have changed dynamically and need to be reloaded.
     */
    public static void refreshProxy() {
        proxy = ProxyConfigReader.getProxy();
    }

    /**
     * Opens a connection to the specified URL string with proxy settings applied.
     *
     * @param url the URL string to which a connection is to be opened
     * @return a HttpURLConnection object pointing to the specified resource
     * @throws IOException if an I/O error occurs while opening the connection
     */
    public static HttpURLConnection openConnection(String url) throws IOException {
        return openConnection(new URL(url));
    }

    /**
     * Opens a connection to the specified URL using the proxy configuration retrieved
     * from the system or environment settings.
     *
     * @param url the URL to which the connection needs to be established.
     * @return an instance of {@link HttpURLConnection} representing the connection to the specified URL.
     * @throws IOException if an I/O exception occurs while opening the connection.
     */
    public static HttpURLConnection openConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection(proxy);
    }

    /**
     * Opens a stream for reading from the specified {@code URL}, using a proxy configuration
     * retrieved via {@code ProxyConfigReader.getProxy()}.
     *
     * @param url the {@code URL} from which the stream should be opened
     * @return an {@code InputStream} to read from the given {@code URL}
     * @throws IOException if an I/O error occurs while opening the connection or stream
     */
    public static InputStream openStream(URL url) throws IOException {
        return url.openConnection(proxy).getInputStream();
    }

    /**
     * Opens an input stream to the resource referenced by the specified URL string.
     *
     * @param url the URL string pointing to the resource to be accessed
     * @return an InputStream to read data from the specified resource
     * @throws IOException if an I/O exception occurs while trying to open the stream
     */
    public static InputStream openStream(String url) throws IOException {
        return openStream(new URL(url));
    }
}
