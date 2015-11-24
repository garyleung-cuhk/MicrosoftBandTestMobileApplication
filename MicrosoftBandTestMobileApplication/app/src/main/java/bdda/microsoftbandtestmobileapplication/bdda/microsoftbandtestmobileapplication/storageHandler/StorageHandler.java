package bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.storageHandler;

import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Accelerometer;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Calories;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Contact;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Distance;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Gyroscope;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.HeartRate;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Pedometer;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.SkinTemperature;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.UV;

/**
 * Created by bdda on 11/23/15.
 */
public interface StorageHandler
{
    public void addAccelerometer( Accelerometer accelerometer );

    public void addCalories( Calories calories );

    public void addContact( Contact contact );

    public void addDistance( Distance distance );

    public void addGyroscope( Gyroscope gyroscope );

    public void addHeartRate( HeartRate heartRate );

    public void addPedometer( Pedometer pedometer );

    public void addSkinTemperature( SkinTemperature skinTemperature );

    public void addUV( UV uv );
}
