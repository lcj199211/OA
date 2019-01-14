package com.casd.dao.supplierMod;

import java.util.Map;

import com.casd.entity.supplierMod.Worker;
import com.casd.entity.supplierMod.WorkerApply;

public interface WorkerDao {

	Boolean checkWorkerExist(String supplierMod_worker_userId);

	void save_Worker(Worker worker);


	void workerApply(WorkerApply workerApply);
	
	void updateworkerApply(WorkerApply workerApply);
	
	Map<String, Object>  findWorker(Map<String, Object> map);
	
	void updateWorker(Worker worker);

	Map<String, Object> getUserByName(Map<String, Object> map);

	void multiplayerApply(Map<String, Object> map);

	void saveWorkerAtt(Map<String, Object> data);


}
