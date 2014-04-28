package framework.mybatis.data.mapper;

import foundation.serialization.Animal;
import framework.mybatis.data.entity.AnimalObj;
import framework.mybatis.data.entity.VmResource;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface AccountingVmResource
{
    void addVmResource(VmResource vm);
    void addAnimal(HashMap map);
    Map getAnimalObject(int id);

}
