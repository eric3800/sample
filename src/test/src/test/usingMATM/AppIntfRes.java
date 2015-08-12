package test.usingMATM;

@SuppressWarnings("serial")
public class AppIntfRes implements java.io.Serializable{


    //--------------------------/
   //- Class/Member Variables -/
  //--------------------------/

  /**
   * Function ID, represent the requested function
   */
  private java.lang.String _functionId;

  /**
   * MAC for the request, functions for logged-on user should
   * provide this element 
   */
  private java.lang.String _MAC;

  /**
   * UserIdentify for logged-on user, functions for logged-on
   * user should provide this element 
   */
  private java.lang.String _userIdentify;

  /**
   * Current session information, functions for logged-on user
   * should provide this element 
   */
  private java.lang.String _session;

  /**
   * Device type, 1:IPhone; 2:Android
   */
  private java.lang.String _deviceType;

  /**
   * Device OS
   */
  private java.lang.String _deviceOS;

  /**
   * Device identify
   */
  private java.lang.String _deviceIdentify;

  /**
   * Request sent time in format yyyymmddhhmmss
   */
  private java.lang.String _reqTime;

  /**
   * Response sent time in format yyyymmddhhmmss
   */
  private java.lang.String _resTime;

  /**
   * Result of request, 0000 means normal, should parse
   * Obj/ObjList to get furthjer result. for other resultCode
   * display ResDesc only
   */
  private java.lang.String _resCode;

  /**
   * Result description, only avail for ResCode != 0000
   */
  private java.lang.String _resDesc;

  /**
   * Field _appIntfResChoice.
   */
//  private com.cienet.svc.mbank.castor.appintfres.AppIntfResChoice _appIntfResChoice;


    //----------------/
   //- Constructors -/
  //----------------/

  public AppIntfRes() {
      super();
  }


    //-----------/
   //- Methods -/
  //-----------/

  /**
   * Returns the value of field 'appIntfResChoice'.
   * 
   * @return the value of field 'AppIntfResChoice'.
   */
//  public com.cienet.svc.mbank.castor.appintfres.AppIntfResChoice getAppIntfResChoice(
//  ) {
//      return this._appIntfResChoice;
//  }

  /**
   * Returns the value of field 'deviceIdentify'. The field
   * 'deviceIdentify' has the following description: Device
   * identify
   * 
   * @return the value of field 'DeviceIdentify'.
   */
  public java.lang.String getDeviceIdentify(
  ) {
      return this._deviceIdentify;
  }

  /**
   * Returns the value of field 'deviceOS'. The field 'deviceOS'
   * has the following description: Device OS
   * 
   * @return the value of field 'DeviceOS'.
   */
  public java.lang.String getDeviceOS(
  ) {
      return this._deviceOS;
  }

  /**
   * Returns the value of field 'deviceType'. The field
   * 'deviceType' has the following description: Device type,
   * 1:IPhone; 2:Android
   * 
   * @return the value of field 'DeviceType'.
   */
  public java.lang.String getDeviceType(
  ) {
      return this._deviceType;
  }

  /**
   * Returns the value of field 'functionId'. The field
   * 'functionId' has the following description: Function ID,
   * represent the requested function
   * 
   * @return the value of field 'FunctionId'.
   */
  public java.lang.String getFunctionId(
  ) {
      return this._functionId;
  }

  /**
   * Returns the value of field 'MAC'. The field 'MAC' has the
   * following description: MAC for the request, functions for
   * logged-on user should provide this element 
   * 
   * @return the value of field 'MAC'.
   */
  public java.lang.String getMAC(
  ) {
      return this._MAC;
  }

  /**
   * Returns the value of field 'reqTime'. The field 'reqTime'
   * has the following description: Request sent time in format
   * yyyymmddhhmmss
   * 
   * @return the value of field 'ReqTime'.
   */
  public java.lang.String getReqTime(
  ) {
      return this._reqTime;
  }

  /**
   * Returns the value of field 'resCode'. The field 'resCode'
   * has the following description: Result of request, 0000 means
   * normal, should parse Obj/ObjList to get furthjer result. for
   * other resultCode display ResDesc only
   * 
   * @return the value of field 'ResCode'.
   */
  public java.lang.String getResCode(
  ) {
      return this._resCode;
  }

  /**
   * Returns the value of field 'resDesc'. The field 'resDesc'
   * has the following description: Result description, only
   * avail for ResCode != 0000
   * 
   * @return the value of field 'ResDesc'.
   */
  public java.lang.String getResDesc(
  ) {
      return this._resDesc;
  }

  /**
   * Returns the value of field 'resTime'. The field 'resTime'
   * has the following description: Response sent time in format
   * yyyymmddhhmmss
   * 
   * @return the value of field 'ResTime'.
   */
  public java.lang.String getResTime(
  ) {
      return this._resTime;
  }

  /**
   * Returns the value of field 'session'. The field 'session'
   * has the following description: Current session information,
   * functions for logged-on user should provide this element 
   * 
   * @return the value of field 'Session'.
   */
  public java.lang.String getSession(
  ) {
      return this._session;
  }

  /**
   * Returns the value of field 'userIdentify'. The field
   * 'userIdentify' has the following description: UserIdentify
   * for logged-on user, functions for logged-on user should
   * provide this element 
   * 
   * @return the value of field 'UserIdentify'.
   */
  public java.lang.String getUserIdentify(
  ) {
      return this._userIdentify;
  }

  /**
   * Method isValid.
   * 
   * @return true if this object is valid according to the schema
   */
  public boolean isValid(
  ) {
      try {
          validate();
      } catch (org.exolab.castor.xml.ValidationException vex) {
          return false;
      }
      return true;
  }

  /**
   * 
   * 
   * @param out
   * @throws org.exolab.castor.xml.MarshalException if object is
   * null or if any SAXException is thrown during marshaling
   * @throws org.exolab.castor.xml.ValidationException if this
   * object is an invalid instance according to the schema
   */
  public void marshal(
          final java.io.Writer out)
  throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
      org.exolab.castor.xml.Marshaller.marshal(this, out);
  }

  /**
   * 
   * 
   * @param handler
   * @throws java.io.IOException if an IOException occurs during
   * marshaling
   * @throws org.exolab.castor.xml.ValidationException if this
   * object is an invalid instance according to the schema
   * @throws org.exolab.castor.xml.MarshalException if object is
   * null or if any SAXException is thrown during marshaling
   */
  public void marshal(
          final org.xml.sax.ContentHandler handler)
  throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
      org.exolab.castor.xml.Marshaller.marshal(this, handler);
  }

  /**
   * Sets the value of field 'appIntfResChoice'.
   * 
   * @param appIntfResChoice the value of field 'appIntfResChoice'
   */
//  public void setAppIntfResChoice(
//          final com.cienet.svc.mbank.castor.appintfres.AppIntfResChoice appIntfResChoice) {
//      this._appIntfResChoice = appIntfResChoice;
//  }

  /**
   * Sets the value of field 'deviceIdentify'. The field
   * 'deviceIdentify' has the following description: Device
   * identify
   * 
   * @param deviceIdentify the value of field 'deviceIdentify'.
   */
  public void setDeviceIdentify(
          final java.lang.String deviceIdentify) {
      this._deviceIdentify = deviceIdentify;
  }

  /**
   * Sets the value of field 'deviceOS'. The field 'deviceOS' has
   * the following description: Device OS
   * 
   * @param deviceOS the value of field 'deviceOS'.
   */
  public void setDeviceOS(
          final java.lang.String deviceOS) {
      this._deviceOS = deviceOS;
  }

  /**
   * Sets the value of field 'deviceType'. The field 'deviceType'
   * has the following description: Device type, 1:IPhone;
   * 2:Android
   * 
   * @param deviceType the value of field 'deviceType'.
   */
  public void setDeviceType(
          final java.lang.String deviceType) {
      this._deviceType = deviceType;
  }

  /**
   * Sets the value of field 'functionId'. The field 'functionId'
   * has the following description: Function ID, represent the
   * requested function
   * 
   * @param functionId the value of field 'functionId'.
   */
  public void setFunctionId(
          final java.lang.String functionId) {
      this._functionId = functionId;
  }

  /**
   * Sets the value of field 'MAC'. The field 'MAC' has the
   * following description: MAC for the request, functions for
   * logged-on user should provide this element 
   * 
   * @param MAC the value of field 'MAC'.
   */
  public void setMAC(
          final java.lang.String MAC) {
      this._MAC = MAC;
  }

  /**
   * Sets the value of field 'reqTime'. The field 'reqTime' has
   * the following description: Request sent time in format
   * yyyymmddhhmmss
   * 
   * @param reqTime the value of field 'reqTime'.
   */
  public void setReqTime(
          final java.lang.String reqTime) {
      this._reqTime = reqTime;
  }

  /**
   * Sets the value of field 'resCode'. The field 'resCode' has
   * the following description: Result of request, 0000 means
   * normal, should parse Obj/ObjList to get furthjer result. for
   * other resultCode display ResDesc only
   * 
   * @param resCode the value of field 'resCode'.
   */
  public void setResCode(
          final java.lang.String resCode) {
      this._resCode = resCode;
  }

  /**
   * Sets the value of field 'resDesc'. The field 'resDesc' has
   * the following description: Result description, only avail
   * for ResCode != 0000
   * 
   * @param resDesc the value of field 'resDesc'.
   */
  public void setResDesc(
          final java.lang.String resDesc) {
      this._resDesc = resDesc;
  }

  /**
   * Sets the value of field 'resTime'. The field 'resTime' has
   * the following description: Response sent time in format
   * yyyymmddhhmmss
   * 
   * @param resTime the value of field 'resTime'.
   */
  public void setResTime(
          final java.lang.String resTime) {
      this._resTime = resTime;
  }

  /**
   * Sets the value of field 'session'. The field 'session' has
   * the following description: Current session information,
   * functions for logged-on user should provide this element 
   * 
   * @param session the value of field 'session'.
   */
  public void setSession(
          final java.lang.String session) {
      this._session = session;
  }

  /**
   * Sets the value of field 'userIdentify'. The field
   * 'userIdentify' has the following description: UserIdentify
   * for logged-on user, functions for logged-on user should
   * provide this element 
   * 
   * @param userIdentify the value of field 'userIdentify'.
   */
  public void setUserIdentify(
          final java.lang.String userIdentify) {
      this._userIdentify = userIdentify;
  }

  /**
   * Method unmarshal.
   * 
   * @param reader
   * @throws org.exolab.castor.xml.MarshalException if object is
   * null or if any SAXException is thrown during marshaling
   * @throws org.exolab.castor.xml.ValidationException if this
   * object is an invalid instance according to the schema
   * @return the unmarshaled
   * com.cienet.svc.mbank.castor.appintfres.AppIntfRes
   */
//  public static com.cienet.svc.mbank.castor.appintfres.AppIntfRes unmarshal(
//          final java.io.Reader reader)
//  throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
//      return (com.cienet.svc.mbank.castor.appintfres.AppIntfRes) org.exolab.castor.xml.Unmarshaller.unmarshal(com.cienet.svc.mbank.castor.appintfres.AppIntfRes.class, reader);
//  }
  public static AppIntfRes unmarshal(
          final java.io.Reader reader)
  throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
      return (AppIntfRes) org.exolab.castor.xml.Unmarshaller.unmarshal(AppIntfRes.class, reader);
  }

  /**
   * 
   * 
   * @throws org.exolab.castor.xml.ValidationException if this
   * object is an invalid instance according to the schema
   */
  public void validate(
  )
  throws org.exolab.castor.xml.ValidationException {
      org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
      validator.validate(this);
  }

}
