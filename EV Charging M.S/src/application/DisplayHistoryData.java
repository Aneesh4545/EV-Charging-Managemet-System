package application;

import java.sql.Date;

public class DisplayHistoryData {
    private int displayHistoryDataId;
    private String name;
    private String phone;
    private String vehicle_no;
    private String vehicleName;
    private Date date;
    private String level;

    public DisplayHistoryData(int displayHistoryDataid, String name, String phone, String vehicle_no, String vehicleName, Date date,
            String level) {
        this.displayHistoryDataId = displayHistoryDataid;
        this.name = name;
        this.phone = phone;
        this.vehicle_no = vehicle_no;
        this.vehicleName = vehicleName;
        this.date = date;
        this.level = level;
    }

    public int getDisplayHistoryDataId() {
        return displayHistoryDataId;
    }

    public void setDisplayHistoryDataId(int id) {
        this.displayHistoryDataId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String no) {
        this.vehicle_no = no;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
