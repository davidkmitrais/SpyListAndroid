package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SpyRealmProxy extends com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy
    implements RealmObjectProxy, SpyRealmProxyInterface {

    static final class SpyColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long ageIndex;
        public long nameIndex;
        public long genderIndex;
        public long passwordIndex;
        public long imageNameIndex;
        public long isIncognitoIndex;

        SpyColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(7);
            this.idIndex = getValidColumnIndex(path, table, "Spy", "id");
            indicesMap.put("id", this.idIndex);
            this.ageIndex = getValidColumnIndex(path, table, "Spy", "age");
            indicesMap.put("age", this.ageIndex);
            this.nameIndex = getValidColumnIndex(path, table, "Spy", "name");
            indicesMap.put("name", this.nameIndex);
            this.genderIndex = getValidColumnIndex(path, table, "Spy", "gender");
            indicesMap.put("gender", this.genderIndex);
            this.passwordIndex = getValidColumnIndex(path, table, "Spy", "password");
            indicesMap.put("password", this.passwordIndex);
            this.imageNameIndex = getValidColumnIndex(path, table, "Spy", "imageName");
            indicesMap.put("imageName", this.imageNameIndex);
            this.isIncognitoIndex = getValidColumnIndex(path, table, "Spy", "isIncognito");
            indicesMap.put("isIncognito", this.isIncognitoIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final SpyColumnInfo otherInfo = (SpyColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.ageIndex = otherInfo.ageIndex;
            this.nameIndex = otherInfo.nameIndex;
            this.genderIndex = otherInfo.genderIndex;
            this.passwordIndex = otherInfo.passwordIndex;
            this.imageNameIndex = otherInfo.imageNameIndex;
            this.isIncognitoIndex = otherInfo.isIncognitoIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final SpyColumnInfo clone() {
            return (SpyColumnInfo) super.clone();
        }

    }
    private SpyColumnInfo columnInfo;
    private ProxyState<com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("age");
        fieldNames.add("name");
        fieldNames.add("gender");
        fieldNames.add("password");
        fieldNames.add("imageName");
        fieldNames.add("isIncognito");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    SpyRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SpyColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$age() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.ageIndex);
    }

    @Override
    public void realmSet$age(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.ageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.ageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$gender() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.genderIndex);
    }

    @Override
    public void realmSet$gender(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.genderIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.genderIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.genderIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.genderIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$password() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.passwordIndex);
    }

    @Override
    public void realmSet$password(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.passwordIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.passwordIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.passwordIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.passwordIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$imageName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.imageNameIndex);
    }

    @Override
    public void realmSet$imageName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.imageNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.imageNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.imageNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.imageNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isIncognito() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isIncognitoIndex);
    }

    @Override
    public void realmSet$isIncognito(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isIncognitoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isIncognitoIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Spy")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Spy");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("age", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("gender", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("imageName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("isIncognito", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Spy");
    }

    public static SpyColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Spy")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Spy' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Spy");
        final long columnCount = table.getColumnCount();
        if (columnCount != 7) {
            if (columnCount < 7) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 7 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 7 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 7 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final SpyColumnInfo columnInfo = new SpyColumnInfo(sharedRealm.getPath(), table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("id") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'id' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'id' does support null values in the existing Realm file. Use corresponding boxed type for field 'id' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("age")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'age' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("age") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'age' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.ageIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'age' does support null values in the existing Realm file. Use corresponding boxed type for field 'age' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("name")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("name") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("gender")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'gender' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("gender") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'gender' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.genderIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'gender' is required. Either set @Required to field 'gender' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("password")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'password' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("password") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'password' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.passwordIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'password' is required. Either set @Required to field 'password' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("imageName")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'imageName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("imageName") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'imageName' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.imageNameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'imageName' is required. Either set @Required to field 'imageName' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("isIncognito")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'isIncognito' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("isIncognito") != RealmFieldType.BOOLEAN) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'isIncognito' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.isIncognitoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'isIncognito' does support null values in the existing Realm file. Use corresponding boxed type for field 'isIncognito' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Spy";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy obj = realm.createObjectInternal(com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy.class, true, excludeFields);
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                ((SpyRealmProxyInterface) obj).realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("age")) {
            if (json.isNull("age")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'age' to null.");
            } else {
                ((SpyRealmProxyInterface) obj).realmSet$age((int) json.getInt("age"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((SpyRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((SpyRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("gender")) {
            if (json.isNull("gender")) {
                ((SpyRealmProxyInterface) obj).realmSet$gender(null);
            } else {
                ((SpyRealmProxyInterface) obj).realmSet$gender((String) json.getString("gender"));
            }
        }
        if (json.has("password")) {
            if (json.isNull("password")) {
                ((SpyRealmProxyInterface) obj).realmSet$password(null);
            } else {
                ((SpyRealmProxyInterface) obj).realmSet$password((String) json.getString("password"));
            }
        }
        if (json.has("imageName")) {
            if (json.isNull("imageName")) {
                ((SpyRealmProxyInterface) obj).realmSet$imageName(null);
            } else {
                ((SpyRealmProxyInterface) obj).realmSet$imageName((String) json.getString("imageName"));
            }
        }
        if (json.has("isIncognito")) {
            if (json.isNull("isIncognito")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isIncognito' to null.");
            } else {
                ((SpyRealmProxyInterface) obj).realmSet$isIncognito((boolean) json.getBoolean("isIncognito"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy obj = new com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((SpyRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
            } else if (name.equals("age")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'age' to null.");
                } else {
                    ((SpyRealmProxyInterface) obj).realmSet$age((int) reader.nextInt());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SpyRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((SpyRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("gender")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SpyRealmProxyInterface) obj).realmSet$gender(null);
                } else {
                    ((SpyRealmProxyInterface) obj).realmSet$gender((String) reader.nextString());
                }
            } else if (name.equals("password")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SpyRealmProxyInterface) obj).realmSet$password(null);
                } else {
                    ((SpyRealmProxyInterface) obj).realmSet$password((String) reader.nextString());
                }
            } else if (name.equals("imageName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SpyRealmProxyInterface) obj).realmSet$imageName(null);
                } else {
                    ((SpyRealmProxyInterface) obj).realmSet$imageName((String) reader.nextString());
                }
            } else if (name.equals("isIncognito")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isIncognito' to null.");
                } else {
                    ((SpyRealmProxyInterface) obj).realmSet$isIncognito((boolean) reader.nextBoolean());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy copyOrUpdate(Realm realm, com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy copy(Realm realm, com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy realmObject = realm.createObjectInternal(com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((SpyRealmProxyInterface) realmObject).realmSet$id(((SpyRealmProxyInterface) newObject).realmGet$id());
            ((SpyRealmProxyInterface) realmObject).realmSet$age(((SpyRealmProxyInterface) newObject).realmGet$age());
            ((SpyRealmProxyInterface) realmObject).realmSet$name(((SpyRealmProxyInterface) newObject).realmGet$name());
            ((SpyRealmProxyInterface) realmObject).realmSet$gender(((SpyRealmProxyInterface) newObject).realmGet$gender());
            ((SpyRealmProxyInterface) realmObject).realmSet$password(((SpyRealmProxyInterface) newObject).realmGet$password());
            ((SpyRealmProxyInterface) realmObject).realmSet$imageName(((SpyRealmProxyInterface) newObject).realmGet$imageName());
            ((SpyRealmProxyInterface) realmObject).realmSet$isIncognito(((SpyRealmProxyInterface) newObject).realmGet$isIncognito());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpyColumnInfo columnInfo = (SpyColumnInfo) realm.schema.getColumnInfo(com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((SpyRealmProxyInterface)object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.ageIndex, rowIndex, ((SpyRealmProxyInterface)object).realmGet$age(), false);
        String realmGet$name = ((SpyRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$gender = ((SpyRealmProxyInterface)object).realmGet$gender();
        if (realmGet$gender != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
        }
        String realmGet$password = ((SpyRealmProxyInterface)object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        }
        String realmGet$imageName = ((SpyRealmProxyInterface)object).realmGet$imageName();
        if (realmGet$imageName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageNameIndex, rowIndex, realmGet$imageName, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isIncognitoIndex, rowIndex, ((SpyRealmProxyInterface)object).realmGet$isIncognito(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpyColumnInfo columnInfo = (SpyColumnInfo) realm.schema.getColumnInfo(com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy.class);
        com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy object = null;
        while (objects.hasNext()) {
            object = (com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((SpyRealmProxyInterface)object).realmGet$id(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.ageIndex, rowIndex, ((SpyRealmProxyInterface)object).realmGet$age(), false);
                String realmGet$name = ((SpyRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$gender = ((SpyRealmProxyInterface)object).realmGet$gender();
                if (realmGet$gender != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
                }
                String realmGet$password = ((SpyRealmProxyInterface)object).realmGet$password();
                if (realmGet$password != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
                }
                String realmGet$imageName = ((SpyRealmProxyInterface)object).realmGet$imageName();
                if (realmGet$imageName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imageNameIndex, rowIndex, realmGet$imageName, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isIncognitoIndex, rowIndex, ((SpyRealmProxyInterface)object).realmGet$isIncognito(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpyColumnInfo columnInfo = (SpyColumnInfo) realm.schema.getColumnInfo(com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((SpyRealmProxyInterface)object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.ageIndex, rowIndex, ((SpyRealmProxyInterface)object).realmGet$age(), false);
        String realmGet$name = ((SpyRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$gender = ((SpyRealmProxyInterface)object).realmGet$gender();
        if (realmGet$gender != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.genderIndex, rowIndex, false);
        }
        String realmGet$password = ((SpyRealmProxyInterface)object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
        }
        String realmGet$imageName = ((SpyRealmProxyInterface)object).realmGet$imageName();
        if (realmGet$imageName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageNameIndex, rowIndex, realmGet$imageName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imageNameIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isIncognitoIndex, rowIndex, ((SpyRealmProxyInterface)object).realmGet$isIncognito(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy.class);
        long tableNativePtr = table.getNativeTablePointer();
        SpyColumnInfo columnInfo = (SpyColumnInfo) realm.schema.getColumnInfo(com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy.class);
        com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy object = null;
        while (objects.hasNext()) {
            object = (com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((SpyRealmProxyInterface)object).realmGet$id(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.ageIndex, rowIndex, ((SpyRealmProxyInterface)object).realmGet$age(), false);
                String realmGet$name = ((SpyRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$gender = ((SpyRealmProxyInterface)object).realmGet$gender();
                if (realmGet$gender != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.genderIndex, rowIndex, false);
                }
                String realmGet$password = ((SpyRealmProxyInterface)object).realmGet$password();
                if (realmGet$password != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
                }
                String realmGet$imageName = ((SpyRealmProxyInterface)object).realmGet$imageName();
                if (realmGet$imageName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imageNameIndex, rowIndex, realmGet$imageName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.imageNameIndex, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.isIncognitoIndex, rowIndex, ((SpyRealmProxyInterface)object).realmGet$isIncognito(), false);
            }
        }
    }

    public static com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy createDetachedCopy(com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy)cachedObject.object;
            } else {
                unmanagedObject = (com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.davidk.oneStopClick.ModelLayer.Database.Realm.Spy();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((SpyRealmProxyInterface) unmanagedObject).realmSet$id(((SpyRealmProxyInterface) realmObject).realmGet$id());
        ((SpyRealmProxyInterface) unmanagedObject).realmSet$age(((SpyRealmProxyInterface) realmObject).realmGet$age());
        ((SpyRealmProxyInterface) unmanagedObject).realmSet$name(((SpyRealmProxyInterface) realmObject).realmGet$name());
        ((SpyRealmProxyInterface) unmanagedObject).realmSet$gender(((SpyRealmProxyInterface) realmObject).realmGet$gender());
        ((SpyRealmProxyInterface) unmanagedObject).realmSet$password(((SpyRealmProxyInterface) realmObject).realmGet$password());
        ((SpyRealmProxyInterface) unmanagedObject).realmSet$imageName(((SpyRealmProxyInterface) realmObject).realmGet$imageName());
        ((SpyRealmProxyInterface) unmanagedObject).realmSet$isIncognito(((SpyRealmProxyInterface) realmObject).realmGet$isIncognito());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Spy = [");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{age:");
        stringBuilder.append(realmGet$age());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{gender:");
        stringBuilder.append(realmGet$gender() != null ? realmGet$gender() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{password:");
        stringBuilder.append(realmGet$password() != null ? realmGet$password() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{imageName:");
        stringBuilder.append(realmGet$imageName() != null ? realmGet$imageName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isIncognito:");
        stringBuilder.append(realmGet$isIncognito());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpyRealmProxy aSpy = (SpyRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSpy.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSpy.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSpy.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
