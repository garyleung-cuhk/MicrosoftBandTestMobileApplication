package bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gary on 1/25/16.
 */
public class Gsr
{
    private Integer id;
    private Integer resistance;
    private String userId;
    private Long timestamp;

    public Integer getId()
    {
        return this.id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public Integer getResistance()
    {
        return this.resistance;
    }

    public void setResistance( Integer resistance )
    {
        this.resistance = resistance;
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
            jsonObj.put( "resistance", this.getResistance() );
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
