select *
from public.clientes

select *
from public.cuentas

select *
from public.movimientos
--SCRIPTS
select count(movimiento_id) from public.movimientos where cuenta_id = 4

select saldo_inicial from public.cuentas where cuenta_id = 4

select max(movimiento_id) from public.movimientos where cuenta_id = 4
	
--REPORTES
select m.fecha, c.numero_cuenta, c.tipo, c.saldo_inicial, c.estado, m.valor, m.saldo
from public.cuentas c, public.movimientos m
where c.cuenta_id = m.cuenta_id
and c.cuenta_id in(1,2)
AND m.fecha::date between '2025-02-01' and '2025-02-28'
---CUENTAS DE un cliente
select c.cuenta_id
from public.cuentas c
where c.cliente_id = 1





