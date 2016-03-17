package bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gary on 2015-06-10.
 */
public class HeartRate {
    private Integer id;
    private Integer hr;
    private String heartRateQuality;
    private String userId;
    private Long timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHr() {
        return hr;
    }

    public void setHr(Integer hr) {
        this.hr = hr;
    }

    public String getHeartRateQuality()
    {
        return this.heartRateQuality;
    }

    public void setHeartRateQuality( String heartRateQuality )
    {
        this.heartRateQuality = heartRateQuality;
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
            jsonObj.put( "hr", this.getHr() );
            jsonObj.put( "userId", this.getUserId() );
            jsonObj.put( "heartRateQuality", this.getHeartRateQuality() );
            jsonObj.put( "timestamp", this.getTimestamp() );
        }
        catch( JSONException e )
        {
            e.printStackTrace();
        }

        return jsonObj;
    }


}
