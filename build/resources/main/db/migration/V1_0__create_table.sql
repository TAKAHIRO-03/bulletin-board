-- 簡易なマスタテーブル
CREATE TABLE IF NOT EXISTS currency(
  id SERIAL NOT NULL,
  name VARCHAR(64) NOT NULL,
  symbol VARCHAR(10) NOT NULL,
  amount DECIMAL(40, 20)
)