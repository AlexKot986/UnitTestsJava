### 1. Почему использование тестовых заглушек может быть полезным при написании модульных тестов?
 	Использование тестовых заглушек при написании модульных тестов облегчает 
	изоляцию кода от его зависимостей, упрощает и ускоряет тестирование, и позволяет проводить тестирование в более широком диапазоне сценариев.
### 2. Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с определенными аргументами?
	Моки (mocks) обычно предоставляют более гибкий и мощный способ проверки вызовов методов и их аргументов в тестах.
### 3. Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение или исключение в ответ на вызов метода?
	Stubs обеспечивают простой способ создания предсказуемых результатов для тестирования без необходимости создания сложных моков.
### 4. Какой тип тестовой заглушки вы бы использовали для имитации  взаимодействия с внешним API или базой данных?
	Для имитации взаимодействия с внешним API или базой данных в модульных тестах обычно используются моки (mocks) или фейковые объекты.