package koreatech.cse.domain.naver;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "lastBuildDate",
        "total",
        "start",
        "display",
        "items"
})
public class NaverNews {
    @JsonProperty("lastBuildDate")
    private String lastBuildDate;
    @JsonProperty("total")
    private String total;
    @JsonProperty("start")
    private String start;
    @JsonProperty("display")
    private String display;
    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();

    @JsonProperty("lastBuildDate")
    public String getLastBuildDate ()
    {
        return lastBuildDate;
    }
    @JsonProperty("lastBuildDate")
    public void setLastBuildDate (String lastBuildDate)
    {
        this.lastBuildDate = lastBuildDate;
    }

    @JsonProperty("total")
    public String getTotal ()
    {
        return total;
    }
    @JsonProperty("total")
    public void setTotal (String total)
    {
        this.total = total;
    }

    @JsonProperty("start")
    public String getStart ()
    {
        return start;
    }
    @JsonProperty("start")
    public void setStart (String start)
    {
        this.start = start;
    }

    @JsonProperty("display")
    public String getDisplay ()
    {
        return display;
    }
    @JsonProperty("display")
    public void setDisplay (String display)
    {
        this.display = display;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }
    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "NaverNews{" +
                "lastBuildDate='" + lastBuildDate + '\'' +
                ", total='" + total + '\'' +
                ", start='" + start + '\'' +
                ", items=" + items +
                ", display='" + display + '\'' +
                '}';
    }
}