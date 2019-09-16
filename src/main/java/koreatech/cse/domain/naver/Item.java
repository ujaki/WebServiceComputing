package koreatech.cse.domain.naver;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "title",
        "originallink",
        "link",
        "description",
        "pubDate"
})
public class Item {
    @JsonProperty("title")
    private String title;
    @JsonProperty("originallink")
    private String originallink;
    @JsonProperty("link")
    private String link;
    @JsonProperty("description")
    private String description;
    @JsonProperty("pubDate")
    private String pubDate;

    @JsonProperty("title")
    public String getTitle ()
    {
        return title;
    }
    @JsonProperty("title")
    public void setTitle (String title)
    {
        this.title = title;
    }

    @JsonProperty("originallink")
    public String getOriginallink ()
    {
        return originallink;
    }
    @JsonProperty("originallink")
    public void setOriginallink (String originallink)
    {
        this.originallink = originallink;
    }

    @JsonProperty("link")
    public String getLink ()
    {
        return link;
    }
    @JsonProperty("link")
    public void setLink (String link)
    {
        this.link = link;
    }

    @JsonProperty("description")
    public String getDescription ()
    {
        return description;
    }
    @JsonProperty("description")
    public void setDescription (String description)
    {
        this.description = description;
    }

    @JsonProperty("pubDate")
    public String getPubDate ()
    {
        return pubDate;
    }
    @JsonProperty("pubDate")
    public void setPubDate (String pubDate)
    {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", originallink='" + originallink + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", pubDate='" + pubDate + '\'' +
                '}';
    }
}