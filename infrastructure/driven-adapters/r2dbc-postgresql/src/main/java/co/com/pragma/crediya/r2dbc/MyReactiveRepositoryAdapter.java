package co.com.pragma.crediya.r2dbc;

import co.com.pragma.crediya.model.user.User;
import co.com.pragma.crediya.model.user.gateways.UserRepository;
import co.com.pragma.crediya.r2dbc.entity.UserEntity;
import co.com.pragma.crediya.r2dbc.helper.ReactiveAdapterOperations;
import co.com.pragma.crediya.r2dbc.mapper.UserEntityMapper;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MyReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        User,
        UserEntity,
        Long,
        MyReactiveRepository
        > implements UserRepository {
    private final UserEntityMapper userEntityMapper;
    public MyReactiveRepositoryAdapter(MyReactiveRepository repository, ObjectMapper mapper, UserEntityMapper userEntityMapper) {
        super(repository, mapper, d -> mapper.map(d, User.class));
        this.userEntityMapper = userEntityMapper;
    }
    @Override
    public Mono<Void> deleteById(String id) {
        return null;
    }
    @Override
    public Mono<User> saveUser(User user) {
        UserEntity toSave = userEntityMapper.toEntity(user);
        return super.repository.save(toSave)
                .map(userEntityMapper::toDomain);
    }
    @Override
    public Mono<Boolean> existsByEmail(String email) {
        return super.repository.existsByEmail(email);
    }
}