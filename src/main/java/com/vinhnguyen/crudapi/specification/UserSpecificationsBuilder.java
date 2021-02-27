package com.vinhnguyen.crudapi.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

import com.vinhnguyen.crudapi.criteria.UserCriteria;
import com.vinhnguyen.crudapi.entites.User;

public class UserSpecificationsBuilder {
	private final List<UserCriteria> params;

	public UserSpecificationsBuilder() {
		this.params = new ArrayList<UserCriteria>();
	}

	public UserSpecificationsBuilder with(String key, String operation, Object value) {
		params.add(new UserCriteria(key, operation, value));
		return this;
	}

	public Specification<User> build() {
		if (params.size() == 0) {
			return null;
		}

		List<Specification> specs = params.stream().map(UserSpecification::new).collect(Collectors.toList());

		Specification result = specs.get(0);

		for (int i = 1; i < params.size(); i++) {
			result = params.get(i).isOrPredicate() ? Specification.where(result).or(specs.get(i))
					: Specification.where(result).and(specs.get(i));
		}
		return result;
	}
}
