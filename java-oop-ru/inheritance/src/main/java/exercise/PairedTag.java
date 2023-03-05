package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> children;

    public PairedTag(String tagName, Map<String, String> tagAttribute, String tagBody, List<Tag> children) {
        super(tagName, tagAttribute);
        this.tagBody = tagBody;
        this.children = children;
    }

    public String toString() {
        StringBuilder string = new StringBuilder(super.toString());
        for(Tag e: children) {
            string.append(e.toString());
        }
        string.append(tagBody).append("</").append(tagName).append(">");
        return string.toString();
    }
}
// END
