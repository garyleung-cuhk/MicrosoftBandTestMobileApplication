/*Copyright (C) 2015  bdda

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>*/

package bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.storageHandler.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Altimeter;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.AmbientLight;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Barometer;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.Gsr;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.dto.RRInterval;
import bdda.microsoftbandtestmobileapplication.bdda.microsoftbandtestmobileapplication.storageHandler.StorageHandler;
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
 * Created by bdda on 2015-06-10.
 */
public class MyDBHandler extends SQLiteOpenHelper implements StorageHandler
{
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "FitnessDB";

    public MyDBHandler( Context context )
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // For Heart Rate
        String createHeartRateDBSql = "CREATE TABLE IF NOT EXISTS HeartRate ( " +
                                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        "hr INTEGER, " +
                                        "heartRateQuality TEXT, " +
                                        "timestamp INTEGER )";


        db.execSQL(createHeartRateDBSql);

        String createContactDBSql = "CREATE TABLE IF NOT EXISTS Contact ( " +
                                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    "contact TEXT, " +
                                    "timestamp INTEGER )";
        db.execSQL( createContactDBSql );

        String createUVDBSql = "CREATE TABLE IF NOT EXISTS UV ( " +
                               "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                               "level TEXT, " +
                               "timestamp INTEGER )";

        db.execSQL( createUVDBSql );

        String createSkinTemperatureDBSql = "CREATE TABLE IF NOT EXISTS SkinTemperature ( " +
                                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                            "temperature TEXT, " +
                                            "timestamp INTEGER )";

        db.execSQL(createSkinTemperatureDBSql);

        String createPedometerDBSql = "CREATE TABLE IF NOT EXISTS Pedometer ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "totalSteps TEXT, " +
                "timestamp INTEGER )";

        db.execSQL(createPedometerDBSql);

        String createAccelerometerDBSql = "CREATE TABLE IF NOT EXISTS Accelerometer ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "accelerationX TEXT, " +
                "accelerationY TEXT, " +
                "accelerationZ TEXT, " +
                "timestamp INTEGER )";

        db.execSQL(createAccelerometerDBSql);

        String createDistanceDBSql = "CREATE TABLE IF NOT EXISTS Distance ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "motionType TEXT, " +
                "pace TEXT, " +
                "speed TEXT, " +
                "totalDistance TEXT, " +
                "timestamp INTEGER )";

        db.execSQL(createDistanceDBSql);

        String createGyroscopeDBSql = "CREATE TABLE IF NOT EXISTS Gyroscope ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "accelerationX TEXT, " +
                "accelerationY TEXT, " +
                "accelerationZ TEXT, " +
                "angularVelocityX TEXT, " +
                "angularVelocityY TEXT, " +
                "angularVelocityZ TEXT, " +
                "timestamp INTEGER )";

        db.execSQL(createGyroscopeDBSql);

        String createCaloriesDBSql = "CREATE TABLE IF NOT EXISTS Calories ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "calories TEXT, " +
                "timestamp INTEGER )";

        db.execSQL(createCaloriesDBSql);

        String createUserIdDBSql = "CREATE TABLE IF NOT EXISTS UserId ( " +
                                   "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                   "userId TEXT, " +
                                   "timestamp INTEGER )";

        db.execSQL(createUserIdDBSql);

        String initUserIdDBSql = "INSERT Into UserId( userId, timestamp ) VALUES( '', 0 )";

        db.execSQL(initUserIdDBSql);

        String createGsrDBSql = "CREATE TABLE IF NOT EXISTS Gsr ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "resistance INTEGER, " +
                "timestamp INTEGER )";

        db.execSQL(createGsrDBSql);

        String createRRIntervalDBSql = "CREATE TABLE IF NOT EXISTS RRInterval ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "interval TEXT, " +
                "timestamp INTEGER )";

        db.execSQL(createRRIntervalDBSql);

        String createAmbientLightDBSql = "CREATE TABLE IF NOT EXISTS AmbientLight ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "brightness INTEGER, " +
                "timestamp INTEGER )";

        db.execSQL(createAmbientLightDBSql);

        String createBarometerDBSql = "CREATE TABLE IF NOT EXISTS Barometer ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "airPressure TEXT, " +
                "temperature TEXT, " +
                "timestamp INTEGER )";

        db.execSQL(createBarometerDBSql);

        String createAltimeterDBSql = "CREATE TABLE IF NOT EXISTS Altimeter ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "flightsAscended TEXT, " +
                "flightsDescended TEXT, " +
                "rate TEXT, " +
                "steppingGain TEXT, " +
                "steppingLoss TEXT, " +
                "stepsAscended TEXT, " +
                "stepsDescended TEXT, " +
                "totalGain TEXT, " +
                "totalLoss TEXT, " +
                "timestamp INTEGER )";

        db.execSQL(createAltimeterDBSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropDBSql = "DROP TABLE IF EXISTS HeartRate";

        db.execSQL(dropDBSql);

        dropDBSql = "DROP TABLE IF EXISTS Contact";

        db.execSQL(dropDBSql);
        dropDBSql = "DROP TABLE IF EXISTS SkinTemperature";

        db.execSQL(dropDBSql);
        dropDBSql = "DROP TABLE IF EXISTS UV";

        db.execSQL(dropDBSql);

        dropDBSql = "DROP TABLE IF EXISTS Pedometer";

        db.execSQL(dropDBSql);

        dropDBSql = "DROP TABLE IF EXISTS Accelerometer";

        db.execSQL(dropDBSql);

        dropDBSql = "DROP TABLE IF EXISTS Distance";

        db.execSQL(dropDBSql);

        dropDBSql = "DROP TABLE IF EXISTS Gyroscope";

        db.execSQL(dropDBSql);

        dropDBSql = "DROP TABLE IF EXISTS Calories";

        db.execSQL(dropDBSql);

        dropDBSql = "DROP TABLE IF EXISTS Gsr";

        db.execSQL(dropDBSql);

        dropDBSql = "DROP TABLE IF EXISTS RRInterval";

        db.execSQL(dropDBSql);

        dropDBSql = "DROP TABLE IF EXISTS AmbientLight";

        db.execSQL(dropDBSql);

        dropDBSql = "DROP TABLE IF EXISTS Barometer";

        db.execSQL(dropDBSql);

        dropDBSql = "DROP TABLE IF EXISTS Altimeter";

        db.execSQL(dropDBSql);

        this.onCreate(db);
    }

    public void addHeartRate( HeartRate heartRate )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("hr", heartRate.getHr());
        values.put( "heartRateQuality", heartRate.getHeartRateQuality() );
        values.put("timestamp", heartRate.getTimestamp());

        db.insert("HeartRate", null, values);

    }

    public void addContact( Contact contact )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("contact", contact.getContact() );
        values.put("timestamp", contact.getTimestamp());

        db.insert("Contact", null, values);
    }

    public void addUV( UV uv )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "level", uv.getLevel() );
        values.put("timestamp", uv.getTimestamp());

        db.insert("UV", null, values);
    }

    public void addSkinTemperature( SkinTemperature skinTemperature )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("temperature", skinTemperature.getTemperature() );
        values.put("timestamp", skinTemperature.getTimestamp());

        db.insert("SkinTemperature", null, values);
    }

    public void addPedometer( Pedometer pedometer )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("totalSteps", pedometer.getTotalSteps() );
        values.put("timestamp", pedometer.getTimestamp());

        db.insert("Pedometer", null, values);
    }

    public void addAccelerometer( Accelerometer accelerometer )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("accelerationX", accelerometer.getAccelerationX() );
        values.put("accelerationY", accelerometer.getAccelerationY());
        values.put("accelerationZ", accelerometer.getAccelerationZ());
        values.put("timestamp", accelerometer.getTimestamp());

        db.insert("Accelerometer", null, values);
    }

    public void addDistance( Distance distance )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("motionType", distance.getMotionType() );
        values.put("pace", distance.getPace());
        values.put("speed", distance.getSpeed());
        values.put("totalDistance", distance.getTotalDistance());
        values.put("timestamp", distance.getTimestamp());

        db.insert("Distance", null, values);
    }

    public void addGyroscope( Gyroscope gyroscope )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("accelerationX", gyroscope.getAccelerationX() );
        values.put("accelerationY", gyroscope.getAccelerationY());
        values.put("accelerationZ", gyroscope.getAccelerationZ());
        values.put("angularVelocityX", gyroscope.getAngularVelocityX() );
        values.put("angularVelocityY", gyroscope.getAngularVelocityY());
        values.put("angularVelocityZ", gyroscope.getAngularVelocityZ());
        values.put("timestamp", gyroscope.getTimestamp());

        db.insert("Gyroscope", null, values);
    }

    public void addCalories( Calories calories )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("calories", calories.getCalories() );
        values.put("timestamp", calories.getTimestamp());

        db.insert("Calories", null, values);
    }

    public void addGsr( Gsr gsr )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "resistance", gsr.getResistance() );
        values.put( "timestamp", gsr.getTimestamp() );

        db.insert( "Gsr", null, values );
    }

    public void addRRInterval( RRInterval rrInterval )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "interval", rrInterval.getInterval() );
        values.put( "timestamp", rrInterval.getTimestamp() );

        db.insert( "RRInterval", null, values );
    }

    public void addAmbientLight( AmbientLight ambientLight )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "brightness", ambientLight.getBrightness() );
        values.put( "timestamp", ambientLight.getTimestamp() );

        db.insert( "AmbientLight", null, values );
    }

    public void addBarometer( Barometer barometer )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "airPressure", barometer.getAirPressure() );
        values.put( "temperature", barometer.getTemperature() );
        values.put( "timestamp", barometer.getTimestamp() );

        db.insert( "Barometer", null, values );
    }

    public void addAltimeter( Altimeter altimeter )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "flightsAscended", altimeter.getFlightsAscended() );
        values.put( "flightsDescended", altimeter.getFlightsDescended() );
        values.put( "rate", altimeter.getRate() );
        values.put( "steppingGain", altimeter.getSteppingGain() );
        values.put( "steppingLoss", altimeter.getSteppingLoss() );
        values.put( "stepsAscended", altimeter.getStepsAscended() );
        values.put( "stepsDescended", altimeter.getStepsDescended() );
        values.put( "totalGain", altimeter.getTotalGain() );
        values.put( "totalLoss", altimeter.getTotalLoss() );
        values.put( "timestamp", altimeter.getTimestamp() );

        db.insert( "Altimeter", null, values );
    }

    public ArrayList<HeartRate> getOldHeartRatesInOffset( int offset )
    {
        ArrayList<HeartRate> heartRateList = new ArrayList<HeartRate>();
        HeartRate tmpHeartRate = null;
        String sql = "SELECT * FROM HeartRate ORDER BY timestamp DESC LIMIT -1 OFFSET " + offset;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpHeartRate = new HeartRate();

                tmpHeartRate.setId(Integer.parseInt(cursor.getString(0)));
                tmpHeartRate.setHr(Integer.parseInt(cursor.getString(1)));

                tmpHeartRate.setHeartRateQuality(cursor.getString(2));


                tmpHeartRate.setTimestamp(Long.parseLong(cursor.getString(3)));

                heartRateList.add( tmpHeartRate );
            }while( cursor.moveToNext() );
        }

        return heartRateList;
    }

    public ArrayList<UV> getOldUVsInOffset( int offset )
    {
        ArrayList<UV> uvList = new ArrayList<UV>();
        UV tmpUV = null;
        String sql = "SELECT * FROM UV ORDER BY timestamp DESC LIMIT -1 OFFSET " + offset;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpUV = new UV();

                tmpUV.setId(Integer.parseInt(cursor.getString(0)));
                tmpUV.setLevel(cursor.getString(1));

                tmpUV.setTimestamp(Long.parseLong(cursor.getString(2)));

                uvList.add(tmpUV);
            }while( cursor.moveToNext() );
        }

        return uvList;
    }

    public ArrayList<Contact> getOldContactsInOffset( int offset )
    {
        ArrayList<Contact> contactList = new ArrayList<Contact>();
        Contact tmpContact = null;
        String sql = "SELECT * FROM Contact ORDER BY timestamp DESC LIMIT -1 OFFSET " + offset;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpContact = new Contact();

                tmpContact.setId(Integer.parseInt(cursor.getString(0)));
                tmpContact.setContact(cursor.getString(1));

                tmpContact.setTimestamp(Long.parseLong(cursor.getString(2)));

                contactList.add(tmpContact);
            }while( cursor.moveToNext() );
        }

        return contactList;
    }

    public ArrayList<SkinTemperature> getOldSkinTemperaturesInOffset( int offset )
    {
        ArrayList<SkinTemperature> skinTemperatureList = new ArrayList<SkinTemperature>();
        SkinTemperature tmpSkinTemperature = null;
        String sql = "SELECT * FROM SkinTemperature ORDER BY timestamp DESC LIMIT -1 OFFSET " + offset;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpSkinTemperature = new SkinTemperature();

                tmpSkinTemperature.setId(Integer.parseInt(cursor.getString(0)));
                tmpSkinTemperature.setTemperature(cursor.getString(1));

                tmpSkinTemperature.setTimestamp(Long.parseLong(cursor.getString(2)));

                skinTemperatureList.add(tmpSkinTemperature);
            }while( cursor.moveToNext() );
        }

        return skinTemperatureList;
    }

    public ArrayList<Pedometer> getOldPedometersInOffset( int offset )
    {
        ArrayList<Pedometer> pedometerList = new ArrayList<Pedometer>();
        Pedometer tmpPedometer = null;
        String sql = "SELECT * FROM Pedometer ORDER BY timestamp DESC LIMIT -1 OFFSET " + offset;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpPedometer = new Pedometer();

                tmpPedometer.setId(Integer.parseInt(cursor.getString(0)));
                tmpPedometer.setTotalSteps(cursor.getString(1));

                tmpPedometer.setTimestamp(Long.parseLong(cursor.getString(2)));

                pedometerList.add(tmpPedometer);
            }while( cursor.moveToNext() );
        }

        return pedometerList;
    }

    public ArrayList<Accelerometer> getOldAccelerometersInOffset( int offset )
    {
        ArrayList<Accelerometer> acceleromterList = new ArrayList<Accelerometer>();
        Accelerometer tmpAccelerometer = null;
        String sql = "SELECT * FROM Accelerometer ORDER BY timestamp DESC LIMIT -1 OFFSET " + offset;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpAccelerometer = new Accelerometer();

                tmpAccelerometer.setId(Integer.parseInt(cursor.getString(0)));
                tmpAccelerometer.setAccelerationX(cursor.getString(1));
                tmpAccelerometer.setAccelerationY(cursor.getString(2));
                tmpAccelerometer.setAccelerationZ(cursor.getString(3));

                tmpAccelerometer.setTimestamp(Long.parseLong( cursor.getString( 4  ) ) );

                acceleromterList.add(tmpAccelerometer);
            }while( cursor.moveToNext() );
        }

        return acceleromterList;
    }

    public ArrayList<Distance> getOldDistancesInOffset( int offset )
    {
        ArrayList<Distance> distanceList = new ArrayList<Distance>();
        Distance tmpDistance = null;
        String sql = "SELECT * FROM Distance ORDER BY timestamp DESC LIMIT -1 OFFSET " + offset;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpDistance = new Distance();

                tmpDistance.setId(Integer.parseInt(cursor.getString(0)));
                tmpDistance.setMotionType(cursor.getString(1));
                tmpDistance.setPace(cursor.getString(2));
                tmpDistance.setSpeed(cursor.getString(3));
                tmpDistance.setTotalDistance(cursor.getString(4));

                tmpDistance.setTimestamp( Long.parseLong(cursor.getString( 5 ) ) );

                distanceList.add(tmpDistance);
            }while( cursor.moveToNext() );
        }

        return distanceList;
    }

    public ArrayList<Gyroscope> getOldGyroscopesInOffset( int offset )
    {
        ArrayList<Gyroscope> gyroscopeList = new ArrayList<Gyroscope>();
        Gyroscope tmpGyroscope = null;
        String sql = "SELECT * FROM Gyroscope ORDER BY timestamp DESC LIMIT -1 OFFSET " + offset;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpGyroscope = new Gyroscope();

                tmpGyroscope.setId(Integer.parseInt(cursor.getString(0)));
                tmpGyroscope.setAccelerationX(cursor.getString(1));
                tmpGyroscope.setAccelerationY(cursor.getString(2));
                tmpGyroscope.setAccelerationZ(cursor.getString(3));
                tmpGyroscope.setAngularVelocityX(cursor.getString(4));
                tmpGyroscope.setAngularVelocityY(cursor.getString(5));
                tmpGyroscope.setAngularVelocityZ(cursor.getString(6));

                tmpGyroscope.setTimestamp(Long.parseLong(  cursor.getString( 7 ) ));

                gyroscopeList.add(tmpGyroscope);
            }while( cursor.moveToNext() );
        }

        return gyroscopeList;
    }

    public ArrayList<Calories> getOldCaloriesInOffset( int offset )
    {
        ArrayList<Calories> caloriesList = new ArrayList<Calories>();
        Calories tmpCalories = null;
        String sql = "SELECT * FROM Calories ORDER BY timestamp DESC LIMIT -1 OFFSET " + offset;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpCalories = new Calories();

                tmpCalories.setId(Integer.parseInt(cursor.getString(0)));
                tmpCalories.setCalories(cursor.getString(1));

                tmpCalories.setTimestamp(Long.parseLong(cursor.getString(2)));

                caloriesList.add(tmpCalories);
            }while( cursor.moveToNext() );
        }

        return caloriesList;
    }

    public ArrayList<Gsr> getOldGsrsInOffset(int offset)
    {
        ArrayList<Gsr> gsrList = new ArrayList<Gsr>();
        Gsr tmpGsr = null;
        String sql = "SELECT * FROM Gsr ORDER BY timestamp DESC LIMIT -1 OFFSET " + offset;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpGsr = new Gsr();

                tmpGsr.setId(Integer.parseInt(cursor.getString(0)));
                tmpGsr.setResistance(cursor.getInt(1));

                tmpGsr.setTimestamp(Long.parseLong(cursor.getString(2)));

                gsrList.add(tmpGsr);
            }while( cursor.moveToNext() );
        }

        return gsrList;
    }

    public ArrayList<RRInterval> getOldRRIntervalsInOffset(int offset)
    {
        ArrayList<RRInterval> rrIntervalList = new ArrayList<RRInterval>();
        RRInterval tmpRRInterval = null;
        String sql = "SELECT * FROM RRInterval ORDER BY timestamp DESC LIMIT -1 OFFSET " + offset;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpRRInterval = new RRInterval();

                tmpRRInterval.setId(Integer.parseInt(cursor.getString(0)));
                tmpRRInterval.setInterval(cursor.getString(1));

                tmpRRInterval.setTimestamp(Long.parseLong(cursor.getString(2)));

                rrIntervalList.add(tmpRRInterval);
            }while( cursor.moveToNext() );
        }

        return rrIntervalList;
    }

    public ArrayList<AmbientLight> getOldAmbientLightInOffset( int offset )
    {
        ArrayList<AmbientLight> ambientLightList = new ArrayList<AmbientLight>();
        AmbientLight tmpAmbientLight = null;
        String sql = "SELECT * FROM AmbientLight ORDER BY timestamp DESC LIMIT -1 OFFSET " + offset;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpAmbientLight = new AmbientLight();

                tmpAmbientLight.setId(Integer.parseInt(cursor.getString(0)));
                tmpAmbientLight.setBrightness(cursor.getInt(1));

                tmpAmbientLight.setTimestamp(Long.parseLong(cursor.getString(2)));

                ambientLightList.add(tmpAmbientLight);
            }while( cursor.moveToNext() );
        }

        return ambientLightList;
    }

    public ArrayList<Barometer> getOldBarometersInOffset(int offset)
    {
        ArrayList<Barometer> barometerList = new ArrayList<Barometer>();
        Barometer tmpBarometer = null;
        String sql = "SELECT * FROM Barometer ORDER BY timestamp DESC LIMIT -1 OFFSET " + offset;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpBarometer = new Barometer();

                tmpBarometer.setId(Integer.parseInt(cursor.getString(0)));
                tmpBarometer.setAirPressure(Double.toString(cursor.getDouble(1)));
                tmpBarometer.setTemperature(Double.toString(cursor.getDouble(2)));

                tmpBarometer.setTimestamp(Long.parseLong(cursor.getString(3)));

                barometerList.add(tmpBarometer);
            }while( cursor.moveToNext() );
        }

        return barometerList;
    }

    public ArrayList<Altimeter> getOldAltimetersInOffset(int offset)
    {
        ArrayList<Altimeter> altimeterList = new ArrayList<Altimeter>();
        Altimeter tmpAltimeter = null;
        String sql = "SELECT * FROM Altimeter ORDER BY timestamp DESC LIMIT -1 OFFSET " + offset;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpAltimeter = new Altimeter();

                tmpAltimeter.setId(Integer.parseInt(cursor.getString(0)));
                tmpAltimeter.setFlightsAscended(Long.toString(cursor.getLong(1)));
                tmpAltimeter.setFlightsDescended(Long.toString(cursor.getLong(2)));
                tmpAltimeter.setRate(Float.toString(cursor.getFloat(3)));
                tmpAltimeter.setSteppingGain(Long.toString(cursor.getLong(4)));
                tmpAltimeter.setSteppingLoss(Long.toString(cursor.getLong(5)));
                tmpAltimeter.setStepsAscended(Long.toString(cursor.getLong(6)));
                tmpAltimeter.setStepsDescended(Long.toString(cursor.getLong(7)));
                tmpAltimeter.setTotalGain(Long.toString(cursor.getLong(8)));
                tmpAltimeter.setTotalLoss(Long.toString(cursor.getLong(9)));

                tmpAltimeter.setTimestamp(Long.parseLong(cursor.getString( 10 )));

                altimeterList.add(tmpAltimeter);
            }while( cursor.moveToNext() );
        }

        return altimeterList;
    }

    public void removeAllHeartRateBelowId( int id )
    {
        String sql = "DELETE FROM HeartRate WHERE id <= " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sql );
    }

    public void removeAllUVBelowId( int id )
    {
        String sql = "DELETE FROM UV WHERE id <= " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sql );
    }

    public void removeAllContactBelowId( int id )
    {
        String sql = "DELETE FROM Contact WHERE id <= " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sql );
    }

    public void removeAllSkinTemperatureBelowId( int id )
    {
        String sql = "DELETE FROM SkinTemperature WHERE id <= " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sql );
    }

    public void removeAllPedometerBelowId( int id )
    {
        String sql = "DELETE FROM Pedometer WHERE id <= " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sql );
    }

    public void removeAllAccelerometerBelowId( int id )
    {
        String sql = "DELETE FROM Accelerometer WHERE id <= " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sql );
    }

    public void removeAllDistanceBelowId( int id )
    {
        String sql = "DELETE FROM Distance WHERE id <= " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sql );
    }

    public void removeAllGyroscopeBelowId( int id )
    {
        String sql = "DELETE FROM Gyroscope WHERE id <= " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sql );
    }

    public void removeAllCaloriesBelowId( int id )
    {
        String sql = "DELETE FROM Calories WHERE id <= " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }

    public void removeAllGsrBelowId( int id )
    {
        String sql = "DELETE FROM Gsr WHERE id <= " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sql );
    }

    public void removeAllRRIntervalBelowId( int id )
    {
        String sql = "DELETE FROM RRInterval WHERE id <= " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sql );
    }

    public void removeAllAmbientLightBelowId( int id )
    {
        String sql = "DELETE FROM AmbientLight WHERE id <= " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sql );
    }

    public void removeAllBarometerBelowId( int id )
    {
        String sql = "DELETE FROM Barometer WHERE id <= " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sql );
    }

    public void removeAllAltimeterBelowId( int id )
    {
        String sql = "DELETE FROM Altimeter WHERE id <= " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sql );
    }

    public ArrayList<HeartRate> getHeartRatesInLimits( int number )
    {
        ArrayList<HeartRate> heartRateList = new ArrayList<HeartRate>();
        HeartRate tmpHeartRate = null;
        String sql = "SELECT * FROM HeartRate ORDER BY timestamp DESC LIMIT " + number;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( sql, null );

        if( cursor.moveToFirst() )
        {
            do
            {
                tmpHeartRate = new HeartRate();

                tmpHeartRate.setId(Integer.parseInt(cursor.getString(0)));
                tmpHeartRate.setHr(Integer.parseInt(cursor.getString(1)));

                tmpHeartRate.setHeartRateQuality(cursor.getString(2));


                tmpHeartRate.setTimestamp(Long.parseLong(cursor.getString(3)));

                heartRateList.add( tmpHeartRate );
            }while( cursor.moveToNext() );
        }

        return heartRateList;
    }
}
