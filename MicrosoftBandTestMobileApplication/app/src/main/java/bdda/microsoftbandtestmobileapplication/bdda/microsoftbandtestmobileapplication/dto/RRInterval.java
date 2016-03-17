package bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gary on 1/25/16.
 */
public class RRInterval {
    private Integer id;
    private String userId;
    private String interval;
    private Long timestamp;

    public Integer getId()
    {
        return this.id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getInterval()
    {
        return this.interval;
    }

    public void setInterval( String interval )
    {
        this.interval = interval;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId( String userId )
    {
        this.userId = userId;
    }

    public JSONObject getJSONObject()
    {
        JSONObject jsonObj = new JSONObject();
        try
        {
            jsonObj.put( "id", this.getId() );
            jsonObj.put( "interval", this.getInterval() );
            jsonObj.put( "userId", this.getUserId() );
            jsonObj.put( "timestamp", this.getTimestamp() );
        }
        catch( JSONException e )
        {
            e.printStackTrace();
        }

        return jsonObj;
    }
}
