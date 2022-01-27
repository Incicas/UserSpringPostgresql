package com.example.UserSpringPostgresql.api;

import com.example.UserSpringPostgresql.dao.AssetEntity;
import com.example.UserSpringPostgresql.dao.AssetRepository;
import com.example.UserSpringPostgresql.dao.UserEntity;
import com.example.UserSpringPostgresql.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class AssetController {

    private UserRepository userRepository;
    private AssetRepository assetRepository;

    @Autowired
    public AssetController(AssetRepository assetRepository, UserRepository userRepository){
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;

    }

    @PostMapping("/{id}")
    public ResponseEntity<AssetEntity> createAsset(@PathVariable long id, @RequestBody AssetEntity assetEntity){
        Optional<UserEntity> userEntity = userRepository.findById(id);

        if (userEntity.isPresent()){
            assetEntity.setUserEntity(userEntity.get());
            assetRepository.save(assetEntity);
            return new ResponseEntity<>(assetEntity, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
