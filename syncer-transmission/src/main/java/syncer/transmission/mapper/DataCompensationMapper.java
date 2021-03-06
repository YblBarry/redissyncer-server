// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// See the License for the specific language governing permissions and
// limitations under the License.

package syncer.transmission.mapper;

import org.apache.ibatis.annotations.*;

import syncer.transmission.model.DataCompensationModel;

import java.util.List;

/**
 * @author zhanenqiang
 * @Description 描述
 * @Date 2020/4/27
 */
@Mapper
public interface DataCompensationMapper {
    // 根据 ID 查询
    @Select("SELECT * FROM t_data_compensation")
    List<DataCompensationModel> selectAll()throws Exception;

    @Select("SELECT * FROM t_data_compensation WHERE taskId =#{taskId}")
    List<DataCompensationModel> findDataCompensationModelListByTaskId(@Param("taskId") String taskId)throws Exception;

    @Select("SELECT * FROM t_data_compensation WHERE groupId =#{groupId}")
    List<DataCompensationModel> findDataCompensationModelListByGroupId(@Param("groupId") String groupId)throws Exception;

    @Insert("INSERT INTO t_data_compensation(taskId,groupId,key,value,times,command) VALUES( #{taskId},#{groupId},#{key},#{value},#{times},#{command})")
    boolean insertDataCompensationModel(DataCompensationModel abandonCommandModel)throws Exception;



    @Delete("DELETE FROM t_data_compensation WHERE id=#{id}")
    void deleteDataCompensationModelById(@Param("id") String id)throws Exception;

    @Delete("DELETE FROM t_data_compensation WHERE taskId=#{taskId}")
    void deleteDataCompensationModelByTaskId(@Param("taskId") String taskId)throws Exception;

    @Delete("DELETE FROM t_data_compensation WHERE groupId=#{groupId}")
    void deleteDataCompensationModelByGroupId(@Param("groupId") String groupId)throws Exception;
}
