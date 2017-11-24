package com.example.inventoryMVP.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 30/10/17.
 */

public class Sector implements Parcelable{

    private int _ID;
    private String name;
    private String sortname;
    private String description;
    private int dependencyID;
    private boolean enabled;
    private boolean defult;

    protected Sector(Parcel in) {
        _ID = in.readInt();
        name = in.readString();
        sortname = in.readString();
        description = in.readString();
        dependencyID = in.readInt();
        enabled = in.readByte() != 0;
        defult = in.readByte() != 0;
    }

    public static final Creator<Sector> CREATOR = new Creator<Sector>() {
        @Override
        public Sector createFromParcel(Parcel in) {
            return new Sector(in);
        }

        @Override
        public Sector[] newArray(int size) {
            return new Sector[size];
        }
    };

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDependencyID() {
        return dependencyID;
    }

    public void setDependencyID(int dependencyID) {
        this.dependencyID = dependencyID;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isDefult() {
        return defult;
    }

    public void setDefult(boolean defult) {
        this.defult = defult;
    }

    public Sector(int _ID, String name, String sortname, String description, int dependencyID, boolean enabled, boolean defult) {
        this._ID = _ID;
        this.name = name;
        this.sortname = sortname;
        this.description = description;
        this.dependencyID = dependencyID;
        this.enabled = enabled;
        this.defult = defult;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(_ID);
        parcel.writeString(name);
        parcel.writeString(sortname);
        parcel.writeString(description);
        parcel.writeInt(dependencyID);
        parcel.writeByte((byte) (enabled ? 1 : 0));
        parcel.writeByte((byte) (defult ? 1 : 0));
    }
}
