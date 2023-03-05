package exercise;

import java.util.Map;

// BEGIN
public class Tag {
    protected String tagName;
    protected Map<String, String> tagAttribute;

    public Tag(String tagName, Map<String, String> tagAttribute) {
        this.tagName = tagName;
        this.tagAttribute = tagAttribute;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("<").append(tagName);
        for (Map.Entry<String,String> enty: tagAttribute.entrySet()) {
            string.append(" ").append(enty.getKey()).append("=\"").append(enty.getValue()).append("\"");
        }
        string.append(">");
        return string.toString();
    }
}
// END
