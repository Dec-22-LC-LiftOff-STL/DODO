package DodoData.models.DodoRepos;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class BuildNestURL {

    private URL url = new URL("http://localhost:4200/api/buildnest");

    public BuildNestURL() throws MalformedURLException {
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public InputStream openStream() {
        return null;
    }
}
