package stock.control.api.mapper;

import stock.control.api.dto.request.ProductRequest;
import stock.control.api.dto.response.ProductResponse;
import stock.control.domain.model.ProductModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

public class ProductMapper {

    public static ProductModel toModel(ProductRequest request) {
        return ProductModel
                .builder()
                .description(request.getDescription())
                .weight(request.getWeight())
                .controlled(request.getControlled())
                .minimumAmount(request.getMinimumAmount())
//                .providerModels(ProviderMapper.toModelList(request.getCodProviderList()))
//                .categoryModel(CategoryModel.builder().idCategory(request.getCodCategory()).build())
                .build();
    }

    public static ProductResponse toResponse(ProductModel productModel) {
        return ProductResponse
                .builder()
                .id(productModel.getId())
                .description(productModel.getDescription())
                .weight(productModel.getWeight())
                .controlled(productModel.getControlled())
                .minimumAmount(productModel.getMinimumAmount())
//                .providerResponseList(ProviderMapper.toResponseList(productModel.getProviderModels()))
//                .nameCategory(productModel.getCategoryModel().getName())
                .build();
    }

    public static List<ProductResponse> toResponseList(List<ProductModel> productModelList) {
        if (isNull(productModelList) || productModelList.isEmpty()) {
            return new ArrayList<>();
        }

        return productModelList
                    .stream()
                    .map(ProductMapper::toResponse)
                    .collect(Collectors.toList());
    }

}
