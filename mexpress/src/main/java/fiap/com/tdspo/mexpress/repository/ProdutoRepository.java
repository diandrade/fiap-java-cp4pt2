package fiap.com.tdspo.mexpress.repository;

import fiap.com.tdspo.mexpress.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
