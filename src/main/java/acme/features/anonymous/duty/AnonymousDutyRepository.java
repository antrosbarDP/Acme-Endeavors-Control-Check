/*
 * AnonymousUserAccountRepository.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.anonymous.duty;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.duties.Duty;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousDutyRepository extends AbstractRepository {

	@Query("select t from Duty t")
	Collection<Duty> findMany();
	
	@Query("select t from Duty t where t.id = ?1")
	Duty findOneById(int id);
	
	@Query("select t from Duty t where (t.isPublic = TRUE AND t.isFinished = FALSE)")
	Collection<Duty> findManyNonFinishedPublic();

}
