package net.klakegg.xml.multixslt.util;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathURIResolver implements URIResolver {

    private Path path;

    public PathURIResolver(Path path) {
        this.path = path;
    }

    @Override
    public Source resolve(String href, String base) throws TransformerException {
        try {
            return new StreamSource(Files.newInputStream(path.resolve(href)));
        } catch (IOException e) {
            throw new TransformerException(e.getMessage(), e);
        }
    }
}
